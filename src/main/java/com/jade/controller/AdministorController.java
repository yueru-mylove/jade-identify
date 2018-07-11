package com.jade.controller;


import com.jade.bean.User;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministorController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/manager/addAdmin")
    public User addAdmin(User user) {
        return null;
    }


    @GetMapping("/manager/login.html")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        User userInfo = userService.getUserInfo(user);
        if (userInfo != null) {
            modelAndView.addObject("user", userInfo);
            modelAndView.setViewName("/manager/main.html");
            return modelAndView;
        }
        modelAndView.setViewName("login.html");
        return modelAndView;
    }
}
