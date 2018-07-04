package com.jade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JadeController {


    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check() {
        return "hello world...";
    }
}
