package com.example.dao.impl;

import com.example.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateDaoImpl {
    private JdbcTemplate jdbcTemplate;
    public int update(User user){
        String sql="update user set password=? where id=?";
        int affected = jdbcTemplate.update(sql, user.getPassword(),user.getId());
        return affected;
    }
    public int delete(Integer id){
        String sql="delete from user where id=?";
        int affected = jdbcTemplate.update(sql,id);
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
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
