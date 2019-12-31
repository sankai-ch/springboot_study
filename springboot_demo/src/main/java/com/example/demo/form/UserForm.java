package com.example.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author SanKai
 * @since 2019-11-06
 */
@Data
public class UserForm {

    @NotBlank
    @ApiModelProperty(value = "用户名", dataType = "String", required = true, example = "admin001")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "用户密码", dataType = "String", required = true, example = "123123")
    private String password;

    @NotBlank
    @ApiModelProperty(value = "用户描述", dataType = "String", required = true, example = "描述描述描述")
    private String description;
}
