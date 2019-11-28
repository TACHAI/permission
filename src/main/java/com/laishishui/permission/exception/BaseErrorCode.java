package com.laishishui.permission.exception;

/**
 * @author jim lin
 *         date 2018/7/17
 * 参数异常基类
 */
public interface BaseErrorCode {
    /**
     * 获得错误码
     * @return 错误码
     */
    String getCode();
    /**
     * 获得错误描述
     * @return 错误描述
     */
    String getDesc();
}
