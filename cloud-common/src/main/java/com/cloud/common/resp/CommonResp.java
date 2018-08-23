package com.cloud.common.resp; /**
 * Created by sh00859 on 2017/7/20.
 */


import com.cloud.common.resp.ResponseCode;

import java.util.List;

/**
 * 通用返回类
 *
 * @author
 * @create 2017-07-20 10:57
 **/
public class CommonResp<T> {
    private String code = ResponseCode.SUCCESS.getCode();
    private String msg = ResponseCode.SUCCESS.getMsg();
    private T result;
    private List<T> resultList;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}