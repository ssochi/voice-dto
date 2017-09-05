package com.xperdit.dto.Enums;

import java.security.InvalidParameterException;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/21 0021.
 */
public enum MsgType {
    VOICE(1),
    TEXT(2),
    PICTURE(3),
    GIF(4);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private MsgType(int value){
        this.value = value;
    }
    public static MsgType valueOf(int value) {
        switch(value) {
            case 1:
                return VOICE;
            case 2:
                return TEXT;
            case 3:
                return PICTURE;
            case 4:
                return GIF;
            default:
                throw new InvalidParameterException();
        }
    }



}
