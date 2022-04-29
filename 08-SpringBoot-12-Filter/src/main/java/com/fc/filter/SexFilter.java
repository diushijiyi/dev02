package com.fc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/*")
//@Component
//@Order(-1)
public class SexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤条件前：只要性别为女的");
        chain.doFilter(request,response);
        System.out.println("过滤条件后：很有女人味");
    }
}
