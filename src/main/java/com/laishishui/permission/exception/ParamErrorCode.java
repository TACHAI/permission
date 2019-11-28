package com.laishishui.permission.exception;

import lombok.Getter;

/**
 * @author jim lin
 *         date 2018/7/17
 *         参数异常集合
 */
@Getter
public enum ParamErrorCode implements BaseErrorCode{

    /**
     * 参数校验不通过 ，未明确具体参数的情况使用该枚举
     */
    PARAMETER_VALID_NOT_PASS("PARAMETER_VALID_NOT_PASS", "参数校验不通过"),
    NULL_IS_ILLEGAL_PARAM("NULL_IS_ILLEGAL_PARAM", "参数为null是非法的"),
    EXPRESSION_NOT_NULL("EXPRESSION_NOT_NULL", "表达式不能为空"),
    EXPRESSION_REEOR("EXPRESSION_REEOR", "表达式有误"),
    EXPRESSION_TRUE("EXPRESSION_TRUE", "表达式正确"),


    //
    ;

    /** 异常码     */
    private String code;
    /** 异常描述     */
    private String desc;
    ParamErrorCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }
}
