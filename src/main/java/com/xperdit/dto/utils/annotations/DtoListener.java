package com.xperdit.dto.utils.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/5 0005.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoListener {
    public Class<? extends com.xperdit.dto.utils.Interfaces.ProxyListener> DtoListener();
}
