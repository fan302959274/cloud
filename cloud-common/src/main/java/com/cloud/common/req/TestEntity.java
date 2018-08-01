package com.cloud.common.req;/**
 * Created by sh00859 on 2018/5/22.
 */

/**
 * @author
 * @create 2018-05-22 15:24
 **/
public class TestEntity {
    private Long id;

    private String paramType;

    private String paramCode;

    private String paramValue;

    private String paramDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
}