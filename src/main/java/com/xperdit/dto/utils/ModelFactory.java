package com.xperdit.dto.utils;

import com.xperdit.dto.utils.mInterface.proxyListener;
import com.xperdit.dto.utils.proxyListener.MapperListener;
import com.xperdit.dto.utils.proxyListener.ToStringListener;
import net.sf.cglib.proxy.Enhancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelFactory {
    static List<proxyListener> listeners = new ArrayList<>();
    public static void addListener(proxyListener listener){
        listeners.add(listener);
    }
    static {
        addListener(new ToStringListener());
        addListener(new MapperListener());
    }
    public static <T> T create(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        ModelProxy proxy = new ModelProxy(clazz);
        proxy.setListeners(listeners);
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }

    public static <T> T create(Class<T> clazz,ModelProxy proxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        proxy.setListeners(listeners);
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }
}
