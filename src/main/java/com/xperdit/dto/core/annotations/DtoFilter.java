package com.xperdit.dto.core.annotations;

import com.xperdit.dto.core.Interfaces.ProxyFilter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 10/4 0004.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoFilter {
    public Class<? extends ProxyFilter> ProxyFilter();
}
