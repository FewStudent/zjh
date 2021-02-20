package com.stylefeng.guns.rest.modular.rest.response;

import java.util.Map;

/**
 * <p>Description</p>
 * <p>响应统一格式</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/8/16
 */
public class ResponseVo {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 其他封装
     */
    private Map<String, Object> data;

    public ResponseVo() {
    }

    public ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
