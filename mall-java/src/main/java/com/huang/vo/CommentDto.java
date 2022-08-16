package com.huang.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentDto implements Serializable {

    private Integer id;

    private Integer commodityId;

    private String commodityName;

    private String userName;

    private String content;

    private String commentTime;
}
