package com.yyl.jvmconsole.utils;

/**
 * leapstack
 * author:yangyuanliang
 * Date:2019-05-21
 * Time:17:04
 **/
public class ResultMap<T> {
    private boolean success;
    private String msg;
    private String errorCode;
    private T data;
    public  ResultMap(){
        this.setSuccess(true);
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
