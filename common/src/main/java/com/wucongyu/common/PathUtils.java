package com.wucongyu.common;

import com.wucongyu.utils.ClassUtils;
import com.wucongyu.utils.RsaUtils;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class PathUtils {
    /**
     * @return 私钥路径
     */
    public static String getPrivateKeyPath() throws URISyntaxException {
        final String classPath = ClassUtils.getClassPath(RsaUtils.class);
        return Paths.get(classPath, "KeyPair", "rsa_privateKey.txt").toString();
    }

    /**
     * @return 公钥路径
     */
    public static String getPublicKeyPath() throws URISyntaxException {
        final String classPath = ClassUtils.getClassPath(RsaUtils.class);
        return Paths.get(classPath, "KeyPair", "rsa_publicKey.txt").toString();
    }

    /**
     * @return 日志根目录
     */
    public static String getLoggerDirectory() throws URISyntaxException {
        final String classPath = ClassUtils.getClassPath(RsaUtils.class);
        return Paths.get(classPath, "logger").toString();
    }
}
