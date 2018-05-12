package com.example.qiany.commonproject.net;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class APIException extends RuntimeException {

    public int code;
    public String message;

    public APIException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
