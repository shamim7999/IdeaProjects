package com.spring.boot.thymeleafone.controller;

import com.spring.boot.thymeleafone.model.LoginData;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class MyController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Shamim");
        model.addAttribute("currentDate", new Date().toString());
        return "about";
    }

    @RequestMapping("/form")
    public String openForm(Model model) {
        model.addAttribute("user", new LoginData());
        return "form";
    }

    //@RequestMapping(path = "/processForm", method = RequestMethod.POST)
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute LoginData loginData, BindingResult result, Model model) {
        model.addAttribute("user", loginData);
        if(result.hasErrors()) {
            System.out.println(result);
            //System.out.println(model.getAttribute("LoginData").toString());
            //return "redirect:/form";
            return "form";
        }
        //model.addAttribute("LoginData", loginData);

        return "success";
    }
}
