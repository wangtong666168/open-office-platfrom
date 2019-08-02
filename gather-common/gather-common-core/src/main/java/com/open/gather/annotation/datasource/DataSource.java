package com.open.gather.annotation.datasource;

import java.lang.annotation.*;


/**
 * 数据源选择
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name();
}