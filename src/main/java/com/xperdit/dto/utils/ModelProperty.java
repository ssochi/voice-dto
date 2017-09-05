package com.xperdit.dto.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xperdit.dto.annotations.DtoListener;
import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.proxyListener.DefinedListener;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelProperty {

    static private ObjectMapper mapper = new ObjectMapper();

    Map<String,ProxyListener> ListenersMap;

    private Class type;

    private Map<String,Object> valMap;

    private Map<String, JavaType> typeMap;

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Map<String, ProxyListener> getListenersMap() {
        return ListenersMap;
    }

    public void setListenersMap(Map<String, ProxyListener> listenersMap) {
        ListenersMap = listenersMap;
    }

    public static ModelProperty getProperty(Class clazz){
        ModelProperty property = new ModelProperty();
        property.type = clazz;
        Map<String,Object> valMap = new HashMap<String,Object>();
        Map<String, JavaType> typeMap = new HashMap<>();
        Map<String,ProxyListener> listenersMap = new HashMap<>();

        Method[] methods = clazz.getMethods();

        Pattern regex = Pattern.compile("^(?<method>([g]et)|(is))(?<property>[A-Z0-9_][A-Za-z0-9_]*)$");

        for (Method m : methods){
            addDtoListener(m,listenersMap);
            Matcher matcher = regex.matcher(m.getName());

            if (matcher.matches()){
                String item = matcher.group("property");
                typeMap.put(item, getJavaTypeByMethod(m));
                valMap.put(item,null);
            }
        }

        property.valMap = valMap;
        property.typeMap = typeMap;
        property.ListenersMap = listenersMap;

        return property;
    }

    private static void addDtoListener(Method m, Map<String, ProxyListener> listenersMap) {
        DtoListener listener = m.getAnnotation(DtoListener.class);
        if (listener!=null){
            try {
                ProxyListener proxyListener = listener.DtoListener().newInstance();
                listenersMap.put(m.getName(),proxyListener);
            } catch (InstantiationException | IllegalAccessException e) {
                //if catch exception , put defined listener on the map , but it just return null = =
                listenersMap.put(m.getName(),new DefinedListener());
                e.printStackTrace();
            }
        }

    }


    public static JavaType getJavaTypeByMethod(Method method){
        Class mainClass = method.getReturnType();
        Type type = method.getGenericReturnType();
        return mapper.getTypeFactory().constructType(type);
    }

    public Map<String, JavaType> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, JavaType> typeMap) {
        this.typeMap = typeMap;
    }
}
