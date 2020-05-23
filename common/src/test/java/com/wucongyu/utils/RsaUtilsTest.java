package com.wucongyu.utils;

import com.wucongyu.common.Constants;
import com.wucongyu.common.PathUtils;
import org.junit.Before;
import org.junit.Test;
import java.net.URISyntaxException;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class RsaUtilsTest {
    @Before
    public void init() throws URISyntaxException {
        System.setProperty("loggerDirectory", PathUtils.getLoggerDirectory());
    }

    @Test
    public void getPublicKey() throws Exception {
        RsaUtils.getPublicKey(PathUtils.getPublicKeyPath());
    }

    @Test
    public void getPrivateKey() throws Exception {
        RsaUtils.getPrivateKey(PathUtils.getPrivateKeyPath());
    }

    @Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey(PathUtils.getPublicKeyPath(), PathUtils.getPrivateKeyPath(), Constants.SECRET, Constants.SECRET_SIZE);
    }
}