package com.xperdit.dto.models;

import com.xperdit.dto.utils.mInterface.mapper;

import java.util.Date;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 8/27 0027.
 */
public interface Message extends mapper {
    public Date getCreate_at();

    public void setCreate_at(Date create_at);

    public UserInfo getPublisher() ;

    public void setPublisher(UserInfo publisher);

    public String getMessageId() ;

    public void setMessageId(String messageId);
}
