package com.laishishui.permission.common;


import com.laishishui.permission.exception.ParamErrorCode;
import com.laishishui.permission.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * @author jim lin
 *         date 2018/6/14
 */
public class ValidateParam {

    private final static ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();


    /**
     * 请求参数非空、格式验证，请求对象
     * 支持嵌套校验，需在私有属性下面加@Valid
     * @param t 请求校验参数
     */
    public static <T> void validateObject(T t) throws ServiceException {
        if(t == null){
            throw new ServiceException(ParamErrorCode.NULL_IS_ILLEGAL_PARAM);
        }
        Validator validator = FACTORY.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (violations.size() == 0) {
            return;
        }

        throw new ServiceException(violations.iterator().next().getMessage());
    }

    /**
     * 请求参数非空、格式验证，请求对象
     * 支持嵌套校验，需在私有属性下面加@Valid
     * @param t 请求校验参数
     * @param clazz 分组class数组
     */
    public static <T> void validateObjectByGroup(T t,Class ... clazz) throws ServiceException{
        if(t == null){
            throw new ServiceException(ParamErrorCode.NULL_IS_ILLEGAL_PARAM);
        }
        Validator validator = FACTORY.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t,clazz);
        if (violations.size() == 0) {
            return;
        }

        throw new ServiceException(violations.iterator().next().getMessage());
    }

    /**
     * 处理 BindingResult 错误信息
     * @param result 错误结果集
     */
    public static String handleBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            return allErrors.get(0).getDefaultMessage();
        }
        return "";
    }

}
