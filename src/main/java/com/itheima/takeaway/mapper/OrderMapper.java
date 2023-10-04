package com.itheima.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.takeaway.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}