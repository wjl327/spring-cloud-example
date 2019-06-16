package com.wjl327.eureka.provider.pojo;

public class RetMsg {

    private int code;
    private String msg;

    public static RetMsg Success = new RetMsg(0, "success");

    public RetMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
