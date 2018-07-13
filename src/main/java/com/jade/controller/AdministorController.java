package com.jade.controller;


/*import com.jade.bean.User;*/
import com.jade.bean.User;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AdministorController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/static/manager/addAdmin")
    public User addAdmin(User user) {
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("test");
        return "login";
    }



    @PostMapping("/manager/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User userInfo = userService.getUserInfo(user);
        if (userInfo != null) {
            HttpSession session = request.getSession();
            String token = UUID.randomUUID().toString();
            session.setAttribute("token", token);
            modelAndView.addObject("user", userInfo);
            modelAndView.setViewName("main");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
