package com.xperdit.dto.core.proxyListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xperdit.dto.core.DtoDefinedDeserializer;
import com.xperdit.dto.core.Interfaces.ProxyListener;
import com.xperdit.dto.core.ModelProperty;
import com.xperdit.dto.core.utils.FormatUtil;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ToStringListener implements ProxyListener {
    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) throws JsonProcessingException {
        return FormatUtil.formatJson(DtoDefinedDeserializer.transModel2Json(obj));
    }

}
