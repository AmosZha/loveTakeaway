package com.itheima.test;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 *
 * @author zhaoYI 2023-09-05 23:25
 * @version 0.1
 * @date 2023-09-05（注：最后更新日期）
 * Modification History:
 * Date         Author       Version     Description
 * ****************************************************
 * 2023-09-05   zhaoYI       0.1         初始开发
 **/

@SpringBootTest(classes=MainClassTest.class)
public class MainClassTest {

    
    /**
     * @Description: stream().map()方法测试
     * @return: void
     * @Date: 2023/9/6
     */
    @Test
    public void writeYourGuess(){
//           List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//
//        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).collect(Collectors.toList());
//
//        numbers.forEach(System.out::println);
//        System.out.println();
//        squaresList.forEach(System.out::println);

        System.out.println(StringUtils.isBlank(" A  B    C "));

    }
}
