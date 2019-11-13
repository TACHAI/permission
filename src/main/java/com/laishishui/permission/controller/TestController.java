package com.laishishui.permission.controller;

import com.laishishui.permission.common.JsonData;
import com.laishishui.permission.exception.PermissionException;
import com.laishishui.permission.util.BeanValidator;
import com.laishishui.permission.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Size;

/**
 * Create by tachai on 2019-11-13 15:30
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
        throw new PermissionException("test exception");
    }


    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo){
        log.info("validate");
        //BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
