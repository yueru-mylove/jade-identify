package com.jade.result;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Result {

    private static final Integer SUCCESS_CODE = 0;
    private static final Integer FAILED_CODE = -1;

    private Integer code;
    private Object data;

    public Result() {

    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static Result success(Object data) {

        return new Result(SUCCESS_CODE, data);
    }

    public static Result failed(Object data) {
        return new Result(FAILED_CODE, null);
    }
}
