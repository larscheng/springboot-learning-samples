package com.larscheng.www.config;

import io.swagger.annotations.ApiModelProperty;

public class Message<T> {
    @ApiModelProperty(value = "响应码",example = "8001")
    private String code;
    @ApiModelProperty(value = "响应描述",example = "操作成功")
    private String msg;
    @ApiModelProperty(value = "响应数据",example = "12345")
    private T data;

    public Message() {
    }

    public String getCode() {
        return code;
    }

    public Message<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Message<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Message<T> setData(T data) {
        this.data = data;
        return this;
    }
}
