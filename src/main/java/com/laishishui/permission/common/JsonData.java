package com.laishishui.permission.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by tachai on 2019-11-11 21:25
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class JsonData {

    private String msg;

    private boolean ret;

    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData success(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data= object;
        jsonData.msg=msg;
        return jsonData;
    }

    public static JsonData  success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data=object;
        return jsonData;
    }

    public static JsonData fail (String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg=msg;
        return  jsonData;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }

}
