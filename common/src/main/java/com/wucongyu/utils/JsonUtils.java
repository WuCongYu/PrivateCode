package com.wucongyu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    public static String toString(Object obj){
        if (obj == null) {
            return null;
        }
        if (obj.getClass()==String.class) {
            return (String)obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：{}",obj,e);
            return null;
        }
    }
    public static <T> T toBean(String json,Class<T> clazz){
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            logger.error("json序列化出错：{}",json,e);
            return null;
        }
    }

    public static <E> List<E> toList(String json,Class<E> clazz){
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            logger.error("json序列化出错：{}",json,e);
            return null;
        }
    }

    public static <K,V>Map<K,V> toMap(String json,Class<K> kClass,Class<V> vClass){
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json序列化出错：{}",json,e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type){
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json序列化出错：{}",json,e);
            return null;
        }
    }
}
