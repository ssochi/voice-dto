package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.annotations.DtoListener;
import com.xperdit.dto.core.proxyListener.ClearListener;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/3 0003.
 */

public interface Clear {
    @DtoListener(DtoListener = ClearListener.class)
    public void clear();
}
