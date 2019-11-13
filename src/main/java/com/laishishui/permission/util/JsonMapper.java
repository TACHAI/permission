package com.laishishui.permission.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

/**
 * Create by tachai on 2019-11-13 15:09
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
// json与object 互相转换
@Slf4j
public class JsonMapper {
    private static ObjectMapper objectMapper=new ObjectMapper();

    static {
        // config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }


    public static <T> String obj2String(T src){
        if(src == null){
            return null;
        }
        try {
            return src instanceof String?(String)src:objectMapper.writeValueAsString(src);
        }catch (Exception e){
            log.warn("parse object to string exception",e);
            return null;
        }
    }


    public static <T> T string2Obj(String src, TypeReference<T> tTypeReference){
        if(src==null || tTypeReference==null){
            return null;
        }
        try{
            return (T) (tTypeReference.getType().equals(String.class)?src:objectMapper.readValue(src,tTypeReference));

        }catch (Exception e){
            log.warn("String to Object exception,String:{},TypeReference<T>:{},error:{}",src,tTypeReference.getType(),e.getMessage());
            return null;
        }
    }


}
