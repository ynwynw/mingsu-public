package com.huang.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDto implements Serializable {

    private Integer id;

    private Integer commodityId;

    private String orderId;

    private String name;

    private String shop;

    private Integer status;

    private String email;

    private BigDecimal price;

}
