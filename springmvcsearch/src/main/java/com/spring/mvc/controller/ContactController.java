package com.spring.mvc.controller;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        if(user.getUserName().isEmpty() || user.getUserEmail().isEmpty() || user.getUserPassword().isEmpty()) {
            return "redirect:/contact";
        }

        this.userService.registerUser(user);
        return "redirect:/dsii/home";
        //return "redirect:https://www.facebook.com";  eta dile --> direct facebook a chole jabe.. But,
        // return "redirect:/https://www.facebook.com"; eta dile --> localhost:8080/springmvc/https://www.facebook.com etay jabe.
    }

    @RequestMapping(path = "/user/{userId}")
    public String loadUserById(@PathVariable("userId") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "success";
    }

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(Model model) {
        model.addAttribute("msg", "Mara Khao");
        return "null_page";
    }
}
