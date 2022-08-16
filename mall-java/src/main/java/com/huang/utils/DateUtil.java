package com.huang.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class DateUtil {

    //如果用户使用使用自定义的时间戳，则不重载，否则重载下列方法
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }


    public static String getJson(Object object, String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        //1、如何让它不要返回时间戳，关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //2、时间格式化问题
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //3、给mapper指定时间格式
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

}
