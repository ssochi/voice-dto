package com.xperdit.dto.models;

import com.xperdit.dto.annotations.Model;
import com.xperdit.dto.enums.MsgType;
import com.xperdit.dto.utils.Interfaces.Utils;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/21 0021.
 */
@Model
public interface MsgResponse extends Utils {
    public UserInfo getInfo();

    public void setInfo(UserInfo info) ;

    public MsgType getType();

    public void setType(MsgType type) ;

    public String getMsgId() ;

    public void setMsgId(String msgId);
}
