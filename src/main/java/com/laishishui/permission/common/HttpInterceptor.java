package com.laishishui.permission.common;

import com.laishishui.permission.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Create by tachai on 2019-11-13 15:44
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
// todo springBoot 拦截器的配置
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    private static final  String START_TIME ="requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 注意敏感信息过滤
        log.info("url:{},params:{}",url, JsonMapper.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request finished. url:{},cost:{}",url,end-start);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request complete . url:{},params:{}",url,JsonMapper.obj2String(parameterMap));
    }
}
