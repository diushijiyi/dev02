package com.example.interceptor;

import com.example.vo.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CacheInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("查询缓存.....");
        HttpSession session = request.getSession(false);
        if(session==null){
            return true;
        }
        Object foods = session.getAttribute("foods");
        if(foods==null){
            return true;
        }
        System.out.println("查到了缓存");
        ResultVO vo = new ResultVO(200, "查到了缓存", true, foods);
        String json = new ObjectMapper().writeValueAsString(vo);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null){
            Map<String, Object> model = modelAndView.getModel();
            Object foods = model.get("foods");
            System.out.println("放到缓存中.....");

            request.getSession(true).setAttribute("foods",foods);
            ResultVO vo = new ResultVO(200, "没有查到缓存", true, foods);
            String json = new ObjectMapper().writeValueAsString(vo);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
        }
    }

}
