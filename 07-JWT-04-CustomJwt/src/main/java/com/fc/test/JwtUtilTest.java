package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtUtilTest {
    @Test
    public void testGetToken() {
        // 准备载荷
        Map<String, Object> claim = new HashMap<>();
        claim.put("username", "赵丽颖");
        claim.put("id", 1);

        // 使用工具类生成jwt
        String token = JwtUtil.getToken(claim, "真美");

        System.out.println(token);

    }
    @Test
    public void testVerifyToken() {
        Map<String, Object> result = JwtUtil.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ6aWhlIiwiaWQiOjEsImV4cCI6MTY0OTI0NjQ5OTIyMywiaWF0IjoxNjQ5MjQ2NDc5MjIzLCJ1c2VybmFtZSI6Iui1teS4vemiliJ9.e9d4eb786d690e7b5e6e34672e4c899a", "真美");
        Set<Map.Entry<String, Object>> entries = result.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
