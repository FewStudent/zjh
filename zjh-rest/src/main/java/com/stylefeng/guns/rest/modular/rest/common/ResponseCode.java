package com.stylefeng.guns.rest.modular.rest.common;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/8/18
 */
public class ResponseCode {
    // 请求成功
    public static final Integer SUCCESS = 200;
    // 请求失败
    public static final Integer FAIL = 502;
    // 短信发送失败
    public static final Integer SMS_SEND_FAILE = 600;
    //验证码错误
    public static final Integer SMS_CODE_ERROR = 601;
    // 非法参数
    public static final Integer PARAMS_ERROR = 400;
    // 用户不存在 / 非法用户
    public static final Integer USER_NOT_EXIST = 401;
    // 资源不存在
    public static final Integer RESOURCES_NOT_EXIST = 402;
    // 没有该与会人员
    public static final Integer NO_MEEETING_USER = 403;
    // 异常
    public static final Integer ERROR = 500;
    // 数据异常
    public static final Integer ABNORMAL_DATA = 1234;


}
