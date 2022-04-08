package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // token头算法
    private static final String ALG = "HS256";
    // token头类型
    private static final String TYP = "JWT";
    // token签名算法
    private static final Algorithm ALGORITHM;
    // token头
    private static final Map<String, Object> HEADER = new HashMap<>();
    // token签名
    private static final String SALT = "zlyyyds";

    // 静态代码块加载token头以及token签名算法
    static {
        HEADER.put("alg", ALG);
        HEADER.put("typ", TYP);
        ALGORITHM = Algorithm.HMAC256(SALT);
    }

    /**
     * 获取Token
     *
     * @param claim 载荷
     * @param expireTime 过期时间，单位：分钟
     * @return token
     */
    public static String getToken(Map<String, Object> claim, Integer expireTime) {
        // 返回创建的token
        return JWT.create().
                // 设置头
                        withHeader(HEADER).
                // 设置过期时间，单位为分钟
                        withExpiresAt(new Date(System.currentTimeMillis() + expireTime * 1000L)).
                // 设置载荷
                        withClaim("claim", claim).
                // 设置签名
                        sign(ALGORITHM);
    }

    /**
     * 解析token
     *
     * @param token token
     * @return 验证的信息
     */
    public static DecodedJWT verify(String token) {
        // 获取token
        return JWT.require(ALGORITHM).build().verify(token);
    }

    /**
     * 根据token获取载荷信息
     *
     * @param token token
     * @return 验证的载荷
     */
    public static Map<String, Object> getClaim(String token) {
        // 获取token中的载荷信息
        return verify(token).getClaim("claim").asMap();
    }

    /**
     * 判断是否过期
     *
     * @param token token
     * @return 是否已过期
     */
    public static boolean isExpiration(String token) {
        return verify(token).getExpiresAt().before(new Date());
    }
}

