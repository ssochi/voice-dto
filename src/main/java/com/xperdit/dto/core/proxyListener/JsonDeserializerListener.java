package com.xperdit.dto.core.proxyListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xperdit.dto.core.DtoDefinedDeserializer;
import com.xperdit.dto.core.Interfaces.ProxyListener;
import com.xperdit.dto.core.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.reflect.Method;

public class JsonDeserializerListener implements ProxyListener {

    static ObjectMapper mapper = new ObjectMapper();






    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws IOException {
        if (args.length != 1)
            return null;

        DtoDefinedDeserializer.transJson2properties(args[0].toString(), property);

        return null;

    }

}
