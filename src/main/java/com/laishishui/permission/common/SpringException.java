package com.laishishui.permission.common;

import com.laishishui.permission.exception.PermissionException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by tachai on 2019-11-11 21:14
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class SpringException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

       String url = request.getRequestURI().toString();
       ModelAndView mv;
       String defaultMsg = "System error";
       // .json, .page
        if (url.endsWith(".json")){
            // 是自定义的异常，才返回错误原因否则 返回默认的
            if(e instanceof PermissionException){
                JsonData jsonData = JsonData.fail(e.getMessage());
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }else {
                JsonData jsonData = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }
        }else if(url.endsWith(".page")) {
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception",result.toMap());
        }else {
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("josnView",result.toMap());
        }
        return mv;
    }
}
