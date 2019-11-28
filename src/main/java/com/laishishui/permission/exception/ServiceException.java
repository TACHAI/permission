package com.laishishui.permission.exception;

import lombok.Getter;

/**
 * @author jim lin
 *         date 2018/7/17
 *      业务流程异常
 */
@Getter
public class ServiceException extends RuntimeException{

    private String errorCode;

    private String errorMsg;


    public ServiceException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    public ServiceException(String errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceException(BaseErrorCode baseErrorCode){
        super(baseErrorCode.getDesc());
        this.errorCode = baseErrorCode.getCode();
        this.errorMsg = baseErrorCode.getDesc();
    }

    public ServiceException(String errorCode, Throwable throwable){
        super(throwable);
        this.errorCode = errorCode;
        this.errorMsg = throwable.getMessage();
    }

    public ServiceException(String errorCode, String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
