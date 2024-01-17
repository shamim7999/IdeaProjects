package com.first.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "DJ");
        return "home";
    }
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(path = "/welcomePerson", method = RequestMethod.POST)
    public String welcomePerson(@RequestParam("person_name") String personName, Model model) {
        model.addAttribute("name", personName);
        System.out.println("In WelcomePerson controller");
        System.out.println(personName);
        return "welcome_person";
    }

}
