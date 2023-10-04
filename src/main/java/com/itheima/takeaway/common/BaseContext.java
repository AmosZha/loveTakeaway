package com.itheima.takeaway.common;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * @Description: 设置值
     * @param id Long
     * @return: void
     * @Date: 2023/9/13
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * @Description: 获取值
     * @return: java.lang.Long
     * @Date: 2023/9/13
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }

    /**
     * @Description: 移除当前线程
     * @return: void
     * @Date: 2023/9/13
     */
    public static void remove(){
        threadLocal.remove();
    }
}