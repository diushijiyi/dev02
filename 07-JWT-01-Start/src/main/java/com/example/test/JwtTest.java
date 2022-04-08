package com.example.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.*;

public class JwtTest {
    @Test
    public void encode(){
        Map<String,Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("typ","JWT");
        Map<String,Object> payload = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,30);
        payload.put("id",1);
        payload.put("username","易烊千玺");
        payload.put("info","管理员");
        payload.put("createTime",new Date());
        payload.put("lastAccessTime",new Date());
        payload.put("exp",instance.getTime());

        String token = JWT
                .create()
                .withHeader(header)
                .withPayload(payload)
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }
    @Test
    public void encode1(){
        Map<String,Object> header = new HashMap<>();
        header.put("alg","HS256");
        header.put("typ","JWT");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,20);

        String token = JWT
                .create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","易烊千玺")
                .withClaim("info","管理员")
                .withClaim("createTime",new Date())
                .withExpiresAt(instance.getTime())
                .withIssuer("玛卡巴卡")
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }
    @Test
    public void decode(){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("123456")).build();
        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVUaW1lIjoxNjQ5MTI1NTU0LCJpc3MiOiLnjpvljaHlt7TljaEiLCJpZCI6MSwiZXhwIjoxNjQ5MTI1NTc0LCJpYXQiOjE2NDkxMjU1NTQsInVzZXJuYW1lIjoi5piT54OK5Y2D5466IiwiaW5mbyI6IueuoeeQhuWRmCJ9.GFH_IWTpA1UoeK5QAnWu2Qp8TXnEI6LgaWy5mbjzHso");
        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getExpiresAt());
        System.out.println(decodedJWT.getClaim("username"));
        System.out.println(decodedJWT.getClaim("createTime"));
        System.out.println(decodedJWT.getClaim("lastAccessTime"));
        System.out.println(decodedJWT.getClaim("info"));
        Map<String, Claim> map = decodedJWT.getClaims();
        Set<Map.Entry<String, Claim>> entries = map.entrySet();
        for (Map.Entry<String, Claim> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
