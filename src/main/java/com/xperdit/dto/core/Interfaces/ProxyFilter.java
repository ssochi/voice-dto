package com.xperdit.dto.core.Interfaces;

import com.xperdit.dto.core.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 10/4 0004.
 */
public interface ProxyFilter {
    public void before(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property);
    public Object after(Object value,Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property);
}
