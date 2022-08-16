package com.huang.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartDto implements Serializable {

    private Integer id;

    private String name;

    private String shop;

    private BigDecimal price;
}
