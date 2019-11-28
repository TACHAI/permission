package com.laishishui.permission.exception;

import lombok.Getter;

/**
 * @author jim lin
 *         date 2018/7/17
 * 流程中验证异常
 */
@Getter
public class ValidateException extends RuntimeException{

    private String errorCode;

    private String errorMsg;

    public ValidateException(String errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ValidateException(BaseErrorCode baseErrorCode){
        super(baseErrorCode.getDesc());
        this.errorCode = baseErrorCode.getCode();
        this.errorMsg = baseErrorCode.getDesc();
    }

    public ValidateException(String errorCode, Throwable throwable){
        super(throwable);
        this.errorCode = errorCode;
        this.errorMsg = throwable.getMessage();
    }

    public ValidateException(String errorCode, String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
