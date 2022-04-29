package com.fc.test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//假设失败后，后面的代码不能执行
@DisplayName("假设")
public class AssumptionTest {
    public String environment="test";
    @Test
    @DisplayName("测试简单的假设")
    void testSimpleAssume(){
        Assumptions.assumeFalse(environment.equals("test"));
        System.out.println("你真帅");
    }
    @Test
    @DisplayName("测试假设之后")
    void testAssumeThen(){
        Assumptions.assumingThat(environment.equals("test"),
                () -> {
                    System.out.println("当前环境是test");
                });
    }
}
