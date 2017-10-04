package com.xperdit.dto.models;

import com.xperdit.dto.core.annotations.Model;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 8/27 0027.
 */
@Model
public interface TextMessage extends Message{
    public String getContent() ;
    public void setContent(String content);
}
