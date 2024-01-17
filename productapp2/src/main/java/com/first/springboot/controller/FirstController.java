package com.first.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloHandler() {
        return "Hello guys...!!";
    }
    @RequestMapping("/")
    public String homeHandler() {
        return "home";
    }
}
