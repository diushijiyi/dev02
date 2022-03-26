package com.example.controller;

import com.example.entity.Student;
import com.example.vo.PageInfo;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/page")
public class PageServlet extends HttpServlet {
    StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("pageNo");
        int pageNo=1;
        if (parameter!=null){
            pageNo=Integer.parseInt(parameter);
        }
        int pageSize=5;
        PageInfo<Student> pageInfo=studentService.getPageInfo(pageNo,pageSize);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("page.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
