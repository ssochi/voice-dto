package com.xperdit.dto.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.proxyListener.*;
import net.sf.cglib.proxy.Enhancer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelFactory {

    public static <T> T create(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        ModelProxy proxy = new ModelProxy(clazz);
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }
    public static <T> T create(Class<T> clazz,String json){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        ModelProxy proxy = new ModelProxy(clazz);
        ModelProperty property = proxy.getProperty();
        try {
            DtoDefinedDeserializer.transJson2properties(json,property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }

    public static <T> T create(Class<T> clazz,ModelProxy proxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }
}
