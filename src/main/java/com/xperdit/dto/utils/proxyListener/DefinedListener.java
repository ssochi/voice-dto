package com.xperdit.dto.utils.proxyListener;

import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/5 0005.
 */
public class DefinedListener implements ProxyListener {

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws Exception {
        return null;
    }
}
