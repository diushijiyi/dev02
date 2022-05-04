package com.fc.service;

import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    ResultVO login(String username, String password);
}
