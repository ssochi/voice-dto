package com.xperdit.dto.models;

import com.xperdit.dto.Enums.MsgType;
import com.xperdit.dto.utils.mInterface.mapper;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/21 0021.
 */
public interface MsgResponse extends mapper {
    public UserInfo getInfo();

    public void setInfo(UserInfo info) ;

    public MsgType getType();

    public void setType(MsgType type) ;


    public Object getMessage() ;

    public void setMessage(Object message) ;
}
