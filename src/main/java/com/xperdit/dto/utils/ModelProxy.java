package com.xperdit.dto.utils;

import com.xperdit.dto.utils.Interfaces.ProxyListener;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelProxy implements MethodInterceptor {
    private ModelProperty property ;
    private List<ProxyListener> listeners;
    ModelProxy(Class type){
        property = ModelProperty.getProperty(type);
    }

    public List<ProxyListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<ProxyListener> listeners) {
        this.listeners = listeners;
    }

    public ModelProxy(ModelProperty property){
        this.property = property;
    }

    public ModelProperty getProperty() {
        return property;
    }

    public void setProperty(ModelProperty property) {
        this.property = property;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String fcName = method.getName();

        for (ProxyListener listener : listeners) {
            if (listener.isAccess(method))
                return listener.callback(obj,method,args,proxy,property);
        }

        MethodType mt = MethodType.getMethodType(method);
        Map<String,Object> map = property.getValMap();

        if (mt.getType()== MethodType.type.SET){
            map.put(mt.getName(),args[0]);
            return null;
        }else if (mt.getType()== MethodType.type.GET){
            return map.get(mt.getName());
        }else{
            throw new NoSuchMethodError("method name must start with get or set or is");
        }


    }

    private Object map(Object arg) {
        Class clazz = (Class) arg;
        ModelProperty inProperty = ModelProperty.getProperty(clazz);
        Map<String,Object> valMap = property.getValMap();
        Map<String,Object> inValMap = inProperty.getValMap();
        for (String val : valMap.keySet()){
            if (inValMap.containsKey(val)){
                inValMap.put(val,valMap.get(val));
            }
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ModelProxy(inProperty));

        return enhancer.create();
    }

}

