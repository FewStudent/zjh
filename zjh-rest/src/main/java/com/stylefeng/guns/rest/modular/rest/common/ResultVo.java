package com.stylefeng.guns.rest.modular.rest.common;

import java.util.Map;

/**
 * <p>Description</p>
 * <p>响应结果集</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
public class ResultVo {

    private Integer code;
    private String msg;
    private Map<String, Object> datas;

    public ResultVo() {
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", datas=" + datas +
                '}';
    }
}
