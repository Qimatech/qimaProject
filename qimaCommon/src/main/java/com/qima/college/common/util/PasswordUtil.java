package com.qima.college.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	/**
     * 对密码字段进行SHA-256加密,并返回加密后的BASE64编码转换
     * @author liuzj
     * @createTime 2015年5月12日 下午3:36:10
     * @param pswd
     *         注意:该字段必须不为空,且长度为6到32位
     * @return
     */
    public static String encodePassword(String pswd) {

        if (pswd == null || pswd.length() < 6 || pswd.length() > 32)

            throw new IllegalArgumentException(
                    //"Incorrect password! The password must not empty and it's length must between 6 and 32 bits long.");
            		"密码输入错误");

        try {

            MessageDigest alga = MessageDigest.getInstance("SHA-256");

            alga.update(pswd.getBytes());

            byte[] hash = alga.digest();

            return StringUtils.base64Encode(hash);

        } catch (NoSuchAlgorithmException e) {

            return "";

        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(encodePassword("123456"));
    }
}
