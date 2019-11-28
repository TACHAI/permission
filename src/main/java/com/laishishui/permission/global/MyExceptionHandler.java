package com.laishishui.permission.global;

import com.laishishui.permission.common.JsonData;
import com.laishishui.permission.common.ValidateParam;
import com.laishishui.permission.exception.ServiceException;
import com.laishishui.permission.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * @author jim lin
 *         2018/7/17.
 *         全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public JsonData handle(ServiceException e) {
        log.warn("业务流程异常，异常信息为：{}", e.getMessage());
        return JsonData.fail(e.getMessage());
    }
    @ExceptionHandler(ValidateException.class)
    public JsonData handle(ValidateException e) {
        log.warn("流程中验证异常，异常信息为：{}", e.getMessage());
        return JsonData.fail(e.getMessage());
    }
    
    /*@ExceptionHandler(BindException.class)
    public <T> ResponseEntity<RespDTO<T>> handle(BindException e) {
    	log.warn("参数检验发生异常，异常信息为：{}", e.getMessage());
    	List<ObjectError> errors = e.getBindingResult().getAllErrors();
    	StringBuilder builder = new StringBuilder();
    	for(ObjectError error :errors){
    		String defalutMessage = error.getDefaultMessage();
    		builder.append(defalutMessage);
    		builder.append("、");
    	}
    	String message = builder.substring(0,builder.length()-1);
    	return ResponseEntity.ok(RespDTO.fail(message));
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonData handle(MethodArgumentNotValidException ex) {
        log.warn("参数校验发生异常，异常信息为：{}", ex.getMessage());
        return JsonData.fail(ValidateParam.handleBindingResult(ex.getBindingResult()));
    }

    @ExceptionHandler(Exception.class)
    @Order
    public JsonData ExceptionHandler(Exception e) {
        log.error("系统异常，异常信息为：{}", e.toString(), e);
        return JsonData.fail(e.getMessage());
    }


}
