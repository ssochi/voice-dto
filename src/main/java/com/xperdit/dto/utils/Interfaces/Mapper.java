package com.xperdit.dto.utils.Interfaces;

import com.xperdit.dto.utils.annotations.*;
import com.xperdit.dto.utils.proxyListener.MapperListener;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public interface Mapper {
    @DtoListener(DtoListener = MapperListener.class)
    public   <T> T map(Class<T> clazz);
}
