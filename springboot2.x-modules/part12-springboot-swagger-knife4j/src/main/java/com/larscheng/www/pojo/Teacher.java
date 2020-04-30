package com.larscheng.www.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午8:46
 * @description:
 */

@ApiModel("Teacher")
public class Teacher {
    @ApiModelProperty(value = "用户id" ,example = "1")
    private Long id;
    @ApiModelProperty(value = "姓名" ,example = "张三")
    private String name;
    @ApiModelProperty(value = "用户名" ,example = "senthink")
    private String username;
    @ApiModelProperty(value = "密码" ,example = "senthink123")
    private String password;
    @ApiModelProperty(value = "年龄" ,example = "20")
    private Integer age;
    @ApiModelProperty(value = "爱好" ,example = "")
    private List<String> hobby;
    private User user;

    public Long getId() {
        return id;
    }

    public Teacher setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Teacher setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Teacher setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Teacher setAge(Integer age) {
        this.age = age;
        return this;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public Teacher setHobby(List<String> hobby) {
        this.hobby = hobby;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Teacher setUser(User user) {
        this.user = user;
        return this;
    }
}
