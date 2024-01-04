package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String showForm() {
        return "contact";
    }

    @RequestMapping(path = "/processForm", method = RequestMethod.POST)
    public String loadForm(@RequestParam("user_name") String userName,
                           @RequestParam("user_email") String userEmail,
                           @RequestParam("user_password") String userPassword,
                           Model model) {
        model.addAttribute("userName", userName);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userPassword", userPassword);

        return "success";
    }
}
