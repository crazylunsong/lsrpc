package com.github.lsrpc.annotation;

import java.lang.annotation.*;

/**
 * <p>date : 2021/3/11 14:03</p>
 * description: 别名
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface Alias {
    /**
     * 名称
     */
    String value();
}
