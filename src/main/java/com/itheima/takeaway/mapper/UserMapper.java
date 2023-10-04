package com.itheima.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.takeaway.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
