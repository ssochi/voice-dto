package com.xperdit.dto.models;

import com.xperdit.dto.utils.annotations.Model;
import com.xperdit.dto.Enums.MsgType;
import com.xperdit.dto.utils.Interfaces.Utils;


import java.util.Date;
import java.util.List;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 8/27 0027.
 */
@Model
public interface Message extends Utils {
    public Date getCreate_at();

    public void setCreate_at(Date create_at);

    public MsgType getMsgType();

    public void setMsgType(MsgType msgType);

    public UserInfo getPublisher() ;

    public void setPublisher(UserInfo publisher);

    public List<UserInfo> getReceivers();

    public void setReceivers(List<UserInfo> receivers);

    public String getMessageId() ;

    public void setMessageId(String messageId);
}
