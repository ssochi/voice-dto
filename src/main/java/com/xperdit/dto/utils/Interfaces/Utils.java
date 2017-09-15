package com.xperdit.dto.utils.Interfaces;

import com.xperdit.dto.utils.annotations.DtoListener;
import com.xperdit.dto.utils.proxyListener.ToStringListener;

public interface Utils extends Mapper, JsonDeserializer, JsonSerializer,Clear {
    @DtoListener(DtoListener = ToStringListener.class)
    public String toString();
}
