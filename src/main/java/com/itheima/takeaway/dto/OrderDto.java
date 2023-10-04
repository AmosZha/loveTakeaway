package com.itheima.takeaway.dto;

import com.itheima.takeaway.entity.OrderDetail;
import com.itheima.takeaway.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends Orders {

    private List<OrderDetail> orderDetails;

    //订单id
    private Long orderId;
}
