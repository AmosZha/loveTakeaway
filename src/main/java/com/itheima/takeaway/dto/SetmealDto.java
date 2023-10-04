package com.itheima.takeaway.dto;

import com.itheima.takeaway.entity.Setmeal;
import com.itheima.takeaway.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
