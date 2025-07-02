package com.ly.lyblogcommon.aspect;

import java.lang.annotation.*;

/**
 * @Author: dly
 * @Date: 2025-07-03-0:01
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {

    String description() default "";


}

