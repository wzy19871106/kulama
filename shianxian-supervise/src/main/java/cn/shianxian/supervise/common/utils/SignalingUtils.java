package cn.shianxian.supervise.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 声网工具类
 */
public class SignalingUtils {


    /**
     * 获取token
     * @param appId
     * @param certificate
     * @param account
     * @param expiredTsInSeconds
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getToken(String appId, String certificate, String account, long expiredTsInSeconds) throws NoSuchAlgorithmException {
        StringBuilder digest = new StringBuilder().append(account).append(appId).append(certificate).append(expiredTsInSeconds);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(digest.toString().getBytes());
        byte[] output = md5.digest();
        String token = hexlify(output);
        String tokenStr = new StringBuilder().append("1").append(":").append(appId).append(":").append(expiredTsInSeconds).append(":").append(token).toString();
        return tokenStr;
    }

    public static String hexlify(byte[] data) {
        char[] digitsLower = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] toDigits = digitsLower;
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return String.valueOf(out);
    }
}