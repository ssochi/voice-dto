package com.xperdit.dto.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.xperdit.dto.core.utils.StringUtils;

import java.io.IOException;
import java.util.*;

public class DtoDefinedDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {
    static ObjectMapper mapper = new ObjectMapper();
    private Class<?> targetClass;

    public DtoDefinedDeserializer() {

    }

    public DtoDefinedDeserializer(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public static void transJson2properties(String json, ModelProperty property) throws IOException {
        JsonParser p = mapper.getJsonFactory().createJsonParser(json);
        transJson2properties(p,property);
    }
    private static void transJson2properties(JsonParser p, ModelProperty property) throws IOException{
        ObjectCodec oc = p.getCodec();
        JsonNode node = (JsonNode) oc.readTree(p);

        Map<String, Object> valMap = property.getValMap();
        Map<String, JavaType> typeMap = property.getTypeMap();
        for (String key : valMap.keySet()) {
            JsonNode currentNode = node.get(StringUtils.toLowerCaseFirstWord(key));
            JavaType javaType = typeMap.get(key);
            new TypeReference<List>(){};
            if (currentNode != null) {
                valMap.put(key, mapper.readValue(currentNode.toString(), javaType));
            }

        }
    }




    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        this.targetClass = ctxt.getContextualType().getRawClass();
        return new DtoDefinedDeserializer(this.targetClass);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ModelProperty property = ModelProperty.getProperty(targetClass);

        transJson2properties(p, property);

        ModelProxy proxy = new ModelProxy(targetClass);
        proxy.setProperty(property);
        return ModelFactory.create(targetClass, proxy);
    }
    public static String transModel2Json(Object model) throws JsonProcessingException {
        return mapper.writeValueAsString(model);
    }
}
