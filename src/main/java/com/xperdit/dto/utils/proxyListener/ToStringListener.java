package com.xperdit.dto.utils.proxyListener;

import com.xperdit.dto.utils.Interfaces.ProxyListener;
import com.xperdit.dto.utils.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class ToStringListener implements ProxyListener {





    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) {
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        for (String val : property.getValMap().keySet()){
            if (val.length()>maxLen)
                maxLen = val.length();
        }
        if (maxLen<9)
            maxLen = 9;
        String typeName = property.getType().getName();
        sb.append(addSpace("modelName : ",maxLen-9));
        sb.append(typeName);
        sb.append("\n");
        Map<String,Object> valMap = property.getValMap();
        for (String val : valMap.keySet()){
            Object object = valMap.get(val);
            if (obj!=null){
                sb.append(addSpace(val + ":", maxLen - val.length()));
                sb.append(" \n");
                sb.append(object);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    private static String addSpace(String str,int counts){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i=0;i<counts;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
