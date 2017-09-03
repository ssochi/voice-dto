package com.xperdit.dto.utils;

import java.util.UUID;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 8/27 0027.
 */
public class ModelUtils {
    public static String createId(){
        return UUID.randomUUID().toString();
    }
}
