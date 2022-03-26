package com.example.dao.impl;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCTemplateDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int update(User user){
        String sql="update user set password=? where id=?";
        int affected = jdbcTemplate.update(sql, user.getPassword(),user.getId());
        return affected;
    }
    public int insert(User user){
        String sql="insert into user(username,password) values (?,?)";
        int affected = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return affected;
    }
    public List<User> findAll(){
        String sql="select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
    public int findCount(){
        String sql="select count(1) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;

    }
    public User findById(Integer id){
        String sql="select * from user where id= ? ";
        User users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return users;
    }
}
