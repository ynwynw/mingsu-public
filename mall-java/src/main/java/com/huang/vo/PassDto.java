package com.huang.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassDto implements Serializable {

    private String pass;

    private String newPass;

    private String checkpass;

}
