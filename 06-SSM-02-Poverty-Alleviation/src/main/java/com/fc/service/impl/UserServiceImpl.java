package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<User> users;
        DataVO<User> userDataVO;
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        if(user.getUsername()!=null){
//            criteria.andUsernameLike("%"+user.getUsername()+"%");
//        }
        if(id!=null){
            users=new ArrayList<>();
            User user = userMapper.selectByPrimaryKey(id);

            if (user==null){

                userDataVO=new DataVO<>(0L,users,pageNum,pageSize);
                resultVO=new ResultVO(4000,"查无此人",false,userDataVO);

            }else {
                users.add(user);
                userDataVO=new DataVO<>(1L,users,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该用户",true,userDataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            users= userMapper.selectByExample(null);
            PageInfo<User> pageInfo = new PageInfo<>();
            userDataVO=new DataVO<>(pageInfo.getTotal(),users,pageNum,pageSize);
            resultVO=new ResultVO(200,"用户查询成功！！！",true,userDataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(User user) {
        ResultVO vo;
        if(user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        int affectedRows = userMapper.insertSelective(user);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加用户成功",true,user);
        }else {
            vo=new ResultVO(5000,"添加用户失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);
        ResultVO vo;
        if(affectedRows>0){
            user=userMapper.selectByPrimaryKey(user.getId());

            vo=new ResultVO(1000,"修改用户成功",true,user);
        }else {
            vo=new ResultVO(5000,"修改用户失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除用户成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除用户失败",false,null);
        }
        return vo;
    }
}
