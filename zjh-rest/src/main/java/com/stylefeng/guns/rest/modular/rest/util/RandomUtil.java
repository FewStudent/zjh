package com.stylefeng.guns.rest.modular.rest.util;

import java.util.UUID;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/8/18
 */
public class RandomUtil {

    public static int getRandomCode() {
        int code = (int) (Math.random() * 1000000);
        return code;
    }

    public static String getRancomSalt(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0,6);
    }

    public static void main(String[] args) {
        System.out.println(getRancomSalt());
    }
}
