package com.tangmo.xizhu.customer.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;
import java.util.UUID;

/**
 * @author Sensor
 * @date 2017/12/19.
 */
@Slf4j
public class EncryptUtil {

    public static final String MD5KEY="XIZHU-SERVICE";

    /**
     * 获取32位UUID
     *
     * @return
     */
    public static String get32Uuid(){
        String uuid = UUID.randomUUID().toString().trim().replace("-","");
        return uuid;
    }

    /**
     * md5加密
     *
     * @param str 要加密的字符串
     * @param isSecondMd5 是否进行二次加密
     * @return md5加密后的字符串
     */
    public static String md5(String str, boolean isSecondMd5) {
        if(isSecondMd5){
            str = DigestUtils.md5Hex(str);
        }
        return DigestUtils.md5Hex(MD5KEY + "_" + str);
    }

    /**
     * 生成指定长度的随机字符串
     *
     * @param length 字符串床长度
     * @return
     */
    public static String randomCode(int length) {
        StringBuilder val = new StringBuilder("");
        Random random = new Random();
        boolean isChar;
        for(int i = 0; i < length; i++) {
            //输出字母还是数字
            isChar = random.nextInt(2) % 2 == 0 ? true : false;
            if(isChar) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val = val.append((char)(random.nextInt(26) + temp));
            } else {
                val = val.append(String.valueOf(random.nextInt(10)));
            }
        }
        return val.toString();
    }
}
