package com.xperdit.dto.utils;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.xperdit.dto.utils.MethodType.type.GET;
import static com.xperdit.dto.utils.MethodType.type.NULL;
import static com.xperdit.dto.utils.MethodType.type.SET;

class MethodType {
        
        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MethodType.type getType() {
        return type;
    }

    public void setType(MethodType.type type) {
        this.type = type;
    }

    private type type;
        public enum type {
            SET(1),
            GET(2),
            NULL(3);

            private int value;

            private type(int value) {
                this.value = value;
            }

            public static type valueOf(int value) {
                switch(value) {
                    case 1:
                        return SET;
                    case 2:
                        return GET;
                    case 3:
                        return NULL;
                    default:
                        throw new InvalidParameterException();
                }
            }

            public int getValue() {
                return this.value;
            }
        }

        public static MethodType getMethodType(Method m){

            MethodType mt = new MethodType();

            Pattern regex = Pattern.compile("^(?<method>([g|s]et)|(is))(?<property>[A-Z0-9_][A-Za-z0-9_]*)$");
            Matcher matcher = regex.matcher(m.getName());
            if (matcher.matches()){

                mt.setName(matcher.group("property"));
                String way = matcher.group("method");
                if (way.equals("is")|way.equals("get")){
                    mt.setType(GET);
                }else if (way.equals("set")){
                    mt.setType(SET);
                }else {
                    mt.setType(NULL);
                }
            }

            return mt;
        }
        
    }