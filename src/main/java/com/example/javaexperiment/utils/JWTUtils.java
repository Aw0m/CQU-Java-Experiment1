package com.example.javaexperiment.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

/**
 * @Author: Awom
 * @Date: 2021/10/27 20:39
 */
public class JWTUtils {
    private static final String TOKEN_SECRET = "my token key";

    /**
     * 生成token，自定义过期时间 毫秒
     */
    public static String createToken(String userName, String password, long expireDate) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + expireDate);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 设置payload信息
            Map<String, String> payload = new HashMap<>(2);
            payload.put("userName", userName);
            payload.put("password", password);
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withExpiresAt(date)
                    .withPayload(payload)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     */
    public static Boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String userName = jwt.getClaim("userName").toString();
            String password = jwt.getClaim("password").toString();
            return true;
//            return jwt.getClaim("userName").toString() + jwt.getClaim("password").toString();
        } catch (JWTVerificationException e){
            e.printStackTrace();
            return false;
        }
    }
}
