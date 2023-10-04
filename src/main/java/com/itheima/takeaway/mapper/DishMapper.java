package com.itheima.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.takeaway.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
