package com.itheima.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.takeaway.common.BaseContext;
import com.itheima.takeaway.common.R;
import com.itheima.takeaway.dto.OrderDto;
import com.itheima.takeaway.entity.OrderDetail;
import com.itheima.takeaway.entity.Orders;
import com.itheima.takeaway.service.OrderDetailService;
import com.itheima.takeaway.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     * @param orders
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单数据：{}",orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * @Description: 用户端·套餐页面
     * @param page int
     * @param pageSize int
     * @return: com.itheima.takeaway.common.R<java.lang.String>
     * @Date: 2023/7/18
     */
    @GetMapping("/userPage")
    public R<Page> userPage(int page,int pageSize){

        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrderDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Orders> orderQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据userId查询
        orderQueryWrapper.eq(BaseContext.getCurrentId() != null, Orders::getUserId, BaseContext.getCurrentId());
        //添加排序条ld件，根据订单时间降序排列
        orderQueryWrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo, orderQueryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Orders> orders = pageInfo.getRecords();

        //封装订单中的订单详情信息
        List<OrderDto> list = orders.stream().map( (item) -> {
            OrderDto orderDto = new OrderDto();

            //对象拷贝
            BeanUtils.copyProperties(item,orderDto);

            //订单id
            Long id = item.getId();
            //根据分类id查询分类对象
            LambdaQueryWrapper<OrderDetail> orderDetailQueryWrapper = new LambdaQueryWrapper<OrderDetail>();
            orderDetailQueryWrapper.eq(OrderDetail::getOrderId, id);

            //根据订单id查询订单详情
            List<OrderDetail> orderDetails = orderDetailService.list(orderDetailQueryWrapper);
            if(orderDetails != null){
                orderDto.setOrderDetails(orderDetails);
                orderDto.setOrderId(id);
            }
            return orderDto;

        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);

    }

    /**
     * @Description: 管理端·查询订单列表
     * @param page int
     * @param pageSize int
     * @return: com.itheima.takeaway.common.R<java.lang.String>
     * @Date: 2023/7/18
     */
    @GetMapping("/page")
    public R<Page> getOrderDetailPage(int page,int pageSize,String number,String beginTime,String endTime){

        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page,pageSize);

        LambdaQueryWrapper<Orders> orderQueryWrapper = new LambdaQueryWrapper<>();

        orderQueryWrapper.like(number != null, Orders::getNumber,number);
        orderQueryWrapper.between(beginTime != null && endTime != null, Orders::getOrderTime, beginTime, endTime);

        //添加排序条件，根据订单时间降序排列
        orderQueryWrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo, orderQueryWrapper);

        return R.success(pageInfo);

    }

    /**
     * @Description: 取消，派送，完成接口
     * @param orders Orders
     * @return: com.itheima.takeaway.common.R<java.lang.String>
     * @Date: 2023/9/7
     */
    @PutMapping
    public R<String> editOrderDetail(@RequestBody Orders orders){

        log.info("订单数据：{}",orders);

        //orderService.editOrderDetail(orders);

        orderService.updateById(orders);

        return R.success("执行成功");
    }

    /**
     * @Description: 再来一单
     * @param request HttpServletRequest
     * @param orders Orders
     * @return: com.itheima.takeaway.common.R<com.itheima.takeaway.entity.Orders>
     * @Date: 2023/9/13
     */
    @PostMapping("again")
    public R<Orders> orderAgain(HttpServletRequest request, @RequestBody Orders orders){
        Orders order = orderService.getById(orders.getId());
        return R.success(order);
    }
}