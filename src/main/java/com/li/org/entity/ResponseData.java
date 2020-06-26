package com.li.org.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.li.org.enums.ResultCode;

/*
 *通用数据返回对象
 */
public class ResponseData<T> {
    private Boolean success = true;
    private Integer code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private int total;

    public ResponseData() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ResponseData(T data) {
        this.data = data;
        this.code=ResultCode.SUCCESS.getCode();
        this.message=ResultCode.SUCCESS.getMessage();
        //this.total = data.size();
    }

    public ResponseData(T data, Integer code, String message) {
        this.data = data;
        //this.total = data.size();
        this.code = code;
        this.message = message;
    }

    public ResponseData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
