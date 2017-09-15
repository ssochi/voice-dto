package com.xperdit.dto.utils.Interfaces;

import com.xperdit.dto.utils.annotations.DtoListener;
import com.xperdit.dto.utils.proxyListener.ClearListener;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/3 0003.
 */

public interface Clear {
    @DtoListener(DtoListener = ClearListener.class)
    public void clear();
}
