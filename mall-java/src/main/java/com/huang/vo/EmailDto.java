package com.huang.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailDto implements Serializable {

    private String title;

    private String text;

    private String toEmail;
}
