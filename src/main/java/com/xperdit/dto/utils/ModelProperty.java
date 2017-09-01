package com.xperdit.dto.utils;

import com.xperdit.dto.utils.mInterface.proxyListener;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ModelProperty {

    List<proxyListener> listeners;

    public List<proxyListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<proxyListener> listeners) {
        this.listeners = listeners;
    }

    private Map<String,Object> valMap;

    private Map<String, Class> typeMap;

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

    private Class type;

    public static ModelProperty getProperty(Class clazz){
        ModelProperty property = new ModelProperty();
        property.type = clazz;
        Map<String,Object> valMap = new HashMap<String,Object>();
        Map<String, Class> typeMap = new HashMap<>();


        Method[] methods = clazz.getMethods();

        Pattern regex = Pattern.compile("^(?<method>([g]et)|(is))(?<property>[A-Z0-9_][A-Za-z0-9_]*)$");

        for (Method m : methods){
            Matcher matcher = regex.matcher(m.getName());
            if (matcher.matches()){
                String item = matcher.group("property");
                typeMap.put(item, m.getReturnType());
                valMap.put(item,null);
            }
        }

        property.valMap = valMap;
        property.typeMap = typeMap;

        return property;
    }

    public Map<String, Class> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Class> typeMap) {
        this.typeMap = typeMap;
    }

}
