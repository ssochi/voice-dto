package com.xperdit.dto.core;

import com.xperdit.dto.core.Interfaces.ProxyFilter;
import com.xperdit.dto.core.Interfaces.ProxyListener;
import com.xperdit.dto.core.annotations.DtoFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelProxy implements MethodInterceptor {
    private ModelProperty property ;

    ModelProxy(Class type){
        property = ModelProperty.getProperty(type);
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

        DtoFilter filter = method.getAnnotation(DtoFilter.class);
        ProxyFilter proxyFilter = null;
        Object res = null;
        if (filter!=null){
            proxyFilter = filter.ProxyFilter().newInstance();
            proxyFilter.before(obj,method,args,proxy,property);
        }

        Map<Method,ProxyListener> proxyListenerMap = property.getListenersMap();
        if (proxyListenerMap.containsKey(method)){
            res = proxyListenerMap.get(method).callback(obj,method,args,proxy,property);
        }else{
            MethodType mt = MethodType.getMethodType(method);
            Map<String,Object> map = property.getValMap();

            if (mt.getType()== MethodType.type.SET){
                map.put(mt.getName(),args[0]);
            }else if (mt.getType()== MethodType.type.GET ){
                res =  map.get(mt.getName());
            }else{
                throw new NoSuchMethodError("method name must start with get or set or is");
            }
        }

        if (proxyFilter!=null){
            res = proxyFilter.after(res,obj,method,args,proxy,property);
        }

        return res;

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

