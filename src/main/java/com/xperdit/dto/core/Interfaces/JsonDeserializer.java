package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.annotations.DtoListener;
import com.xperdit.dto.core.proxyListener.JsonDeserializerListener;

public interface JsonDeserializer {
    @DtoListener(DtoListener = JsonDeserializerListener.class)
    public Object fromJson(String json);
}
