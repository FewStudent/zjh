package com.stylefeng.guns.rest.modular.rest.excel;

import java.lang.annotation.*;

/**
 * 定义了实体类所需要的Bean
 */
@Target({ElementType.FIELD}) //该注解作用在域上
/**
 * 生命周期
 * 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在，
 * 保存到class对象中，可以通过反射来获取
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    String value() default "";

    int col() default 0;
}