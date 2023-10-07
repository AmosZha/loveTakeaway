package com.itheima.takeaway.common;

/**
 * 通用常量信息
 * @author zhaoYI 2023-10-08 00:45
 * @version 0.1
 * @date 2023-10-08（注：最后更新日期）
 * Modification History:
 * Date         Author       Version     Description
 * ****************************************************
 * 2023-10-08   zhaoYI       0.1         初始开发
 **/

public class Constants {

    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.ruoyi" };
}
