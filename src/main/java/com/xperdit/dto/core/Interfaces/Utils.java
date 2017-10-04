package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.annotations.DtoListener;
import com.xperdit.dto.core.proxyListener.ToStringListener;

public interface Utils extends Mapper, JsonDeserializer, JsonSerializer,Clear {
    @DtoListener(DtoListener = ToStringListener.class,overwriteObject = true)
    public String toString();
}
