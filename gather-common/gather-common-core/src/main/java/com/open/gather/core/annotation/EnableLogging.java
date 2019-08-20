package com.open.gather.core.annotation;

import com.open.gather.core.aopconfigure.LoggingConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 启动日志框架支持
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//自动装配starter
@Import(LoggingConfigurationSelector.class)
public @interface EnableLogging{
//	String name() ;
}