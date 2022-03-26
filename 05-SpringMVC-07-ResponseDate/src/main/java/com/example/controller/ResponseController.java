package com.example.controller;

import com.example.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("response")
public class ResponseController {
    @RequestMapping("testVoid")
    public void testVoid() {
        System.out.println("测试返回值是void，无法被视图解析了");
    }

    @RequestMapping("testString")
    public String testString() {
        System.out.println("测试返回值是String，直接进行跳转");
        return "/success.jsp";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", "易烊千玺");
        mv.setViewName("/success.jsp");
        return mv;
    }

    @RequestMapping("testModelAndView2")
    public ModelAndView testModelAndView2(ModelAndView mv) {
        mv.addObject("username", "赵丽颖");
        mv.setViewName("/success.jsp");
        return mv;
    }

    @RequestMapping("testModelAndView3")
    public String testModelAndView3(Model model) {
        model.addAttribute("username", "玛卡巴卡");
        return "/success.jsp";
    }

    @RequestMapping("testVoidRedirect")
    public void testVoidRedirect(HttpServletResponse response) {
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testVoidForward")
    public void testVoidForward(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("username", "玛卡巴卡");
        try {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testStringRedirect")
    public String testStringRedirect() {
        return "redirect:/success.jsp";
    }

    @RequestMapping("testStringForward")
    public String testStringForward(Model model) {
        model.addAttribute("username", "唔西迪西");
        return "forward:/success.jsp";
    }

    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody() {
        System.out.println("测试@ResponseBody注解");
    }

    @RequestMapping("testResponseBodyString")
    @ResponseBody
    public String testResponseBodyString() {
        return "/success.jsp";
    }

    @RequestMapping(value = "testHtmlString", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testHtmlString() {
        return "<h1 align=\"center\" style=\"color:yellowgreen;\">易烊千玺</h1>\n";
    }

    @RequestMapping(value = "testJsonString", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonString() {
        return "{\"username\":\"易烊千玺\",\"password\":\"123456\"}";
    }

    @RequestMapping(value = "testJsonObject", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonObject() {
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
    @RequestMapping(value = "testObject", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User testObject() {
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");
        return user;
    }
    @RequestMapping(value = "testMap", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> testMap() {
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");
        ArrayList<String> foods = new ArrayList<>();
        foods.add("烤羊排");
        foods.add("考羊肉");
        foods.add("烤玉米");
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("success",true);
        map.put("message","成功");
        map.put("data",user);
        map.put("foods",foods);
        return map;
    }
}
