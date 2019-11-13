package com.laishishui.permission.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Create by tachai on 2019-11-13 15:23
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

   //定义一个全局的context
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T popBean(Class<T> clazz){
        if(applicationContext==null){
            return null;
        }
        return applicationContext.getBean(clazz);
    }


    public static <T> T popBean(String name,Class<T> clazz){
        if(applicationContext==null){
            return null;
        }
        return applicationContext.getBean(name,clazz);
    }
}
