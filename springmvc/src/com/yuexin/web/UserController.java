package com.yuexin.web;

import com.yuexin.bean.User;
import com.yuexin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-9-26
 * Time: 上午8:29
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "User")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "checkLogin")
    public ModelAndView checkLogin(User user){
        ModelAndView modelAndView = new ModelAndView();
        if (userService.existsUser(user)){
            modelAndView.addObject("message","您好："+ user.getName());
        }else {
            modelAndView.addObject("message","登陆错误");
        }
        modelAndView.setViewName("message");
        return modelAndView;
    }
}
