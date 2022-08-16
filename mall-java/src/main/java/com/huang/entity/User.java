package com.huang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huang
 * @since 2021-09-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="User对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String pass;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "收货邮箱")
    private String email;

    @ApiModelProperty(value = "是否为店家")
    private String isBusiness;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "居住地")
    private String address;

}
