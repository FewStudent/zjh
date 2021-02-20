package com.stylefeng.guns;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 */
@SpringBootApplication
public class ZjhAdminApplication {

    private final static Logger logger = LoggerFactory.getLogger(ZjhAdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZjhAdminApplication.class, args);
        logger.info("Application is success!");
    }
}
