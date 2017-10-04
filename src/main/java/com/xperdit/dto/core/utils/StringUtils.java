package com.xperdit.dto.core.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class StringUtils {
    public static String toUpperCaseFirstWord(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    public static String toLowerCaseFirstWord(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
    public static  String methodHash(Method m){
        Parameter[]  ps = m.getParameters();
        int hash = m.hashCode();
        for (Parameter p : ps){
            hash ^= p.hashCode();
        }
        return hash+"";
    }
}
