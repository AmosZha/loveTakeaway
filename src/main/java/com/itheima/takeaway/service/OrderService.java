package com.itheima.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.takeaway.entity.Orders;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);

    /**
     * @Description:  取消，派送，完成接口
     * @param orders Orders
     * @return: void
     * @Date: 2023/9/7
     */
    public void editOrderDetail(Orders orders);
}
