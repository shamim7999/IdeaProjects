package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    @RequestMapping("/google")
    public String redirectExample() {
        return "redirect:https://www.google.com";
    }
}
