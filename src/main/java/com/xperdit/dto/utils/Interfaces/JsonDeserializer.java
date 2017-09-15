package com.xperdit.dto.utils.Interfaces;

import com.xperdit.dto.utils.annotations.DtoListener;
import com.xperdit.dto.utils.proxyListener.JsonDeserializerListener;

public interface JsonDeserializer {
    @DtoListener(DtoListener = JsonDeserializerListener.class)
    public Object fromJson(String json);
}
