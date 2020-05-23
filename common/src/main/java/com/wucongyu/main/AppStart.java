package com.wucongyu.main;

import com.wucongyu.common.Constants;
import com.wucongyu.common.PathUtils;
import com.wucongyu.utils.RsaUtils;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 吴聪宇
 * @version 1.0
 */
public class AppStart {
    public static final Logger logger = LoggerFactory.getLogger(AppStart.class);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20000; i++) {
            logger.error(">>>>>>>>>>>>>>>>>>>");
        }
        //RsaUtils.generateKey(PathUtils.getPublicKeyPath(), PathUtils.getPrivateKeyPath(), Constants.SECRET, Constants.SECRET_SIZE);
    }
}
