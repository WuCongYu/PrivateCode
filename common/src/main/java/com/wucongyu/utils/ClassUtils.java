package com.wucongyu.utils;

import cn.hutool.core.util.ClassUtil;

import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class ClassUtils {
    /**
     * 获取类路径
     */
    public static String getClassPath(Class clazz) throws URISyntaxException {
        return Paths.get(ClassUtil.getLocation(clazz).toURI()).toString();
    }
}
