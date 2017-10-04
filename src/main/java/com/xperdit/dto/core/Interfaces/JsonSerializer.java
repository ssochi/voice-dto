package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.annotations.DtoListener;
import com.xperdit.dto.core.proxyListener.JsonSerializerListener;

public interface JsonSerializer {
    @DtoListener(DtoListener = JsonSerializerListener.class)
    public String toJson();
}
