package com.xperdit.dto.utils.models;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright reserved by Beijing Xperdit Technology Co., Ltd. 9/4 0004.
 */
public class JavaClass {
    boolean isCollection = false;
    Class MainClass ;
    Class IncludeClass;
    static Set<String> collectionSet = new HashSet<>();


    public static JavaClass fromMethod(Method m){
        JavaClass javaClass = new JavaClass();
        javaClass.setMainClass(m.getReturnType());
        if (javaClass.getMainClass().equals(List.class)){
            Type type = m.getGenericReturnType();
            String typeName = type.getTypeName();
            int from = typeName.indexOf("<");
            int to = typeName.indexOf(">");
            if (from >=0 && to >= 0){
                String includeClassName = typeName.substring(from+1,to);

                try {
                    Class IncludeClazz = Class.forName(includeClassName);
                    javaClass.setIncludeClass(IncludeClazz);
                    javaClass.setCollection(true);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return javaClass;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public Class getMainClass() {
        return MainClass;
    }

    public void setMainClass(Class mainClass) {
        MainClass = mainClass;
    }

    public Class getIncludeClass() {
        return IncludeClass;
    }

    public void setIncludeClass(Class includeClass) {
        IncludeClass = includeClass;
    }
}
