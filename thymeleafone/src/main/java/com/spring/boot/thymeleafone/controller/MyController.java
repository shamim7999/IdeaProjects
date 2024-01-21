package com.spring.boot.thymeleafone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MyController {
    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Shamim");
        model.addAttribute("currentDate", new Date().toString());
        return "about";
    }
}
