package com.stylefeng.guns.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@MapperScan(value = {"com.stylefeng.guns.rest.modular.rest.dao"})
public class GunsRestApplication {

    private static final Logger log = LoggerFactory.getLogger(GunsRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GunsRestApplication.class, args);
        log.info("application run success");
    }
}
