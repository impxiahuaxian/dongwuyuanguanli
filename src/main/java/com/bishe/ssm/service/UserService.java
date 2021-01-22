package com.bishe.ssm.service;

import com.bishe.ssm.bean.User;
import com.bishe.ssm.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service层
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * 跳转登录页面
     * @param user
     * @return
     */
    public User checkLogin1(User user){
        User user1 = userMapper.checkLogin(user);
        return user1;
    }

    /**
     * 跳转注册页面
     * @param user
     */
    public void SignUp(User user) {
        userMapper.SignUp(user);
    }
}
