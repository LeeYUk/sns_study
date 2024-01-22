package com.study.sns_study.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    public static String encodePassword(String password){
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword= md.digest(password.getBytes(StandardCharsets.UTF_8));

            //바이트 배열을 16진수 문자열로 변환
            BigInteger number=new BigInteger(1,hashedPassword);
            StringBuilder hexString=new StringBuilder(number.toString(16));

            //문자열이 32자가 될 때까지 앞에 0을 채움
            while (hexString.length()<32){
                hexString.insert(0,'0');
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
