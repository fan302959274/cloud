package com.cloud.common.enums;

/**
 * Created by sh00859 on 2018/9/6.
 */
public enum OperateEnum {

    ADD("ADD", "添加"),
    DELETE("DELETE", "减少");
    private String code;
    private String message;

    OperateEnum(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
