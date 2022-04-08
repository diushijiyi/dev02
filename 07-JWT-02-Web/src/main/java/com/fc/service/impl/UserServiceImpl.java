package com.fc.service.impl;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVO login(String username, String password) {
        UserVO userVO=null;
        if(username.equals("赵丽颖")&&password.equals("123456")){
            userVO=new UserVO();
            userVO.setId(1);
            userVO.setUsername(username);
            userVO.setLastAccessTime(new Date());
        }
        return userVO;
    }
}
