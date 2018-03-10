package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);
    
    public static String stringToMD5(String str){
        try {
            MessageDigest msgDigst = MessageDigest.getInstance("MD5");
            byte[] md5 = msgDigst.digest(str.getBytes("UTF-8"));
            return new String(md5);
        } catch (NoSuchAlgorithmException algEx) {
            logger.error(algEx.getMessage(), algEx);
            throw new RuntimeException(algEx);
        } catch (UnsupportedEncodingException encEx) {
            logger.error(encEx.getMessage(), encEx);
            throw new RuntimeException(encEx);
        }
    }

}
