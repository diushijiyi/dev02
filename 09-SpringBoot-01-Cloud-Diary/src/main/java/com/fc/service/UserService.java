package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    ResultVO login(String username, String password);

    Integer checkNick(String nick);

    ResultVO update(MultipartFile img, TbUser user);
}
