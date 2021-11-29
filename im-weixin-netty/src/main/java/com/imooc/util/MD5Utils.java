package com.imooc.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * 解密网站：https://www.cmd5.com/
 * 学习工程，安全性不用设置这么高
 */
public class MD5Utils {
    /**
     * @Description: 对字符串进行md5加密
     *
     */
    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        System.out.println("加密的字符串：" + newstr + "\t长度：" + newstr.length());
        return newstr;
    }

    public static void main(String[] args) {
        try {
            String md5 = getMD5Str("imooc");
            System.out.println(md5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
