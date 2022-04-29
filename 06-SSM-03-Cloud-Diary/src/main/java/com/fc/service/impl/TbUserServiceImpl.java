package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.TbUserService;
import com.fc.util.JdbcUtilsOnDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Number remember) {

        ModelAndView modelAndView = new ModelAndView();

        // 获取核心类对象
        QueryRunner queryRunner = new QueryRunner();

        // 获取数据库连接
        Connection connection = JdbcUtilsOnDruid.getConnection();

        // 准备SQL语句
        String sql = "select * from user where username = ? and password = ?";

        // 提取实体类对象
        TbUser user = null;
        Object[] params={username,password};
        try {
            // 执行SQL语句并获取实体类对象
            user = queryRunner.query(connection, sql, new BeanHandler<>(TbUser.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 如果实体类对象不为null，说明查询到数据
        if (user != null) {
            HttpSession session = request.getSession(true);

            // 设置过期时间
            session.setMaxInactiveInterval(60 * 60);

            // 设置登录到的用户名为参数
            session.setAttribute("username", username);

            // 创建Cookie并存入JSESSIONID
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            if(remember.equals(0)){
                cookie.setMaxAge(0);
            }else {
                // 设置Cookie过期时间
                cookie.setMaxAge(60 * 60);
            }
            // 通过响应对象将Cookie发送到浏览器
            modelAndView.addObject(cookie);
            modelAndView.setViewName("/index/page");
        } else {
            modelAndView.setViewName("/index");
        }
        return modelAndView;
    }
}
