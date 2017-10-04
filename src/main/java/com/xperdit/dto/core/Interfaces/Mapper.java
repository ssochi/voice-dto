package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.annotations.*;
import com.xperdit.dto.core.proxyListener.MapperListener;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public interface Mapper {
    @DtoListener(DtoListener = MapperListener.class)
    public   <T> T map(Class<T> clazz);
}
