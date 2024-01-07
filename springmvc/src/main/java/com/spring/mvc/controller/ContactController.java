package com.spring.mvc.controller;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;

@Controller
public class ContactController {

    @Autowired
    private UserService userService;

    @RequestMapping("/contact")
    public String showForm() {
        return "contact";
    }

    /*
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

     */
    @RequestMapping(path = "/processForm", method = RequestMethod.POST)
    public String loadForm(@ModelAttribute User user,
                           Model model) {
        this.userService.registerUser(user);
        return "success";
    }
}
