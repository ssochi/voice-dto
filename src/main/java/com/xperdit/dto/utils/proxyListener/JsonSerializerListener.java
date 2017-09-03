package com.xperdit.dto.utils.proxyListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JsonSerializerListener implements ProxyListener {

    static ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean isAccess(Method m) {
        return m.getName().equals("toJson");
    }

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws Exception {

        return mapper.writeValueAsString(obj);
    }
}
