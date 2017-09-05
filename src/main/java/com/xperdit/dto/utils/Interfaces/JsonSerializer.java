package com.xperdit.dto.utils.Interfaces;

import com.xperdit.dto.annotations.DtoListener;
import com.xperdit.dto.utils.proxyListener.JsonDeserializerListener;
import com.xperdit.dto.utils.proxyListener.JsonSerializerListener;

public interface JsonSerializer {
    @DtoListener(DtoListener = JsonSerializerListener.class)
    public String toJson();
}
