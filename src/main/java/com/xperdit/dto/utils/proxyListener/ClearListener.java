package com.xperdit.dto.utils.proxyListener;

import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/3 0003.
 */
public class ClearListener implements ProxyListener {
    @Override
    public boolean isAccess(Method m) {
        return m.getName().equals("clear");
    }

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws Exception {
        Map<String,Object> valMap = property.getValMap();
        for (String key : valMap.keySet()){
            valMap.put(key,null);
        }
        return null;
    }
}
