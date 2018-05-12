package com.example.qiany.commonproject.bean;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class HttpResult<T> {

    private int errorCode;

    private String errorMsg;

    private T data;

    public HttpResult(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public boolean isSuccess() {
        return errorCode >= 0;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getData() {
        return data;
    }
}
