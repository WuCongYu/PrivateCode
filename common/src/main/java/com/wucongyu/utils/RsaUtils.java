package com.wucongyu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class RsaUtils {
    private static final int DEFAULT_KEY_SIZE = 2048;
    private static final Logger logger = LoggerFactory.getLogger(RsaUtils.class);
    /**
     * @param filename 公钥保存路径，相对于classpath
     */
    public static PublicKey getPublicKey(String filename)throws Exception{
        byte[] bytes = readFile(filename);
        return getPublicKey(bytes);
    }

    /**
     * @param filename 私钥保存路径，相对于classpath
     */
    public static PrivateKey getPrivateKey(String filename)throws Exception{
        byte[] bytes = readFile(filename);
        return getPrivateKey(bytes);
    }

    /**
     * @param bytes 公钥的字节形式
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception{
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * @param bytes 私钥的字节形式
     */
    private static PrivateKey getPrivateKey(byte[] bytes)throws NoSuchAlgorithmException, InvalidKeySpecException{
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    /**
     * @param publicKeyFilename 公钥保存路径
     * @param privateKeyFilename 私钥保存路径
     * @param secret 生成密钥的密文（盐）
     */
    public static void generateKey(String publicKeyFilename,String privateKeyFilename,String secret,int keySize)throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize,DEFAULT_KEY_SIZE),secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename,publicKeyBytes);
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    private static byte[] readFile(String filename)throws Exception{
        return Files.readAllBytes(new File(filename).toPath());
    }

    private static void writeFile(String destPath,byte[] bytes)throws IOException{
        File dest = new File(destPath);
        if (!dest.exists()){
            final boolean newFile = dest.createNewFile();
            if (!newFile) {
                logger.warn("文件创建失败：{}",destPath);
            }
        }
        Files.write(dest.toPath(), bytes);
    }
}
