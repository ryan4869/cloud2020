package com.atguigu.springcloud.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonUtils {

    @Autowired
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJson(Object object){
        String res = null;
        try {
            res = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
