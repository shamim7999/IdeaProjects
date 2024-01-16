package com.spring.mvc.controller;

import com.spring.mvc.helpers.ModelTransporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", ModelTransporter.getModel().getAttribute("name"));
        return "home";
    }
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(path = "/welcomePerson", method = RequestMethod.POST)
    public String welcomePerson(@RequestParam("person_name") String personName, Model model) {
        model.addAttribute("name", personName);
        return "welcome_person";
    }
}
