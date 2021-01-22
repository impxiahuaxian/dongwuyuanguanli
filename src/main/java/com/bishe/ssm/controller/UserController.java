package com.bishe.ssm.controller;

import com.bishe.ssm.bean.User;
import com.bishe.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 跳转到登录页面
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(User user, Model model){
        return "login";
    }

    /**
     * 跳转到菜单页面
     * @param session
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, User user, Model model) {
        User user1=userService.checkLogin1(user);
        if(user1!=null){
            //登录成功
            session.setAttribute("user", user);
            return "/order";
        }else{
//            往前台传数据
            model.addAttribute("msg","输入的用户名或密码错误，请重新输入！");
            return "login";
        }
    }


    /**
     * 跳转到注册页面
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/SignUp")
    public String SignUp(User user,Model model){
        userService.SignUp(user);
        model.addAttribute("reg", "注册成功！");
        return "login";
    }


}
