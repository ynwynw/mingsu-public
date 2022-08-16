package com.huang.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class OrderUtil {

    /**
     *  根据时间戳生成订单号
     * */
    public static String getOrderNo () {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return df.format(localDateTime);
    }
}
