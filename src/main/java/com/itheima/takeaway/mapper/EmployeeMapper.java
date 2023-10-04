package com.itheima.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.takeaway.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
