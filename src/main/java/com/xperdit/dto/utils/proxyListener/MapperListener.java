package com.xperdit.dto.utils.proxyListener;

import com.xperdit.dto.utils.ModelFactory;
import com.xperdit.dto.utils.ModelProperty;
import com.xperdit.dto.utils.ModelProxy;
import com.xperdit.dto.utils.mInterface.proxyListener;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class MapperListener implements proxyListener {

    @Override
    public boolean isAccess(Method m) {
        return m.getName().equals("map");
    }

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) {
        Class clazz = (Class) args[0];
        ModelProperty inProperty = ModelProperty.getProperty(clazz);
        Map<String,Object> valMap = property.getValMap();
        Map<String,Object> inValMap = inProperty.getValMap();
        for (String val : valMap.keySet()){
            if (inValMap.containsKey(val)){
                inValMap.put(val,valMap.get(val));
            }
        }

        return ModelFactory.create(clazz,new ModelProxy(inProperty));
    }


}
