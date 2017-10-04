package com.xperdit.dto.core.proxyListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xperdit.dto.core.DtoDefinedDeserializer;
import com.xperdit.dto.core.Interfaces.ProxyListener;
import com.xperdit.dto.core.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JsonSerializerListener implements ProxyListener {

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws Exception {
        return DtoDefinedDeserializer.transModel2Json(obj);
    }
}
