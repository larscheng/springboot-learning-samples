package com.larscheng.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午8:52
 * @description:
 */
@ApiModel("UserVo")
public class UserVo extends PageVo{
    @ApiModelProperty(value = "用户名" ,example = "senthink")
    private String username;
    @ApiModelProperty(value = "密码" ,example = "senthink123")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserVo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserVo setPassword(String password) {
        this.password = password;
        return this;
    }
}
