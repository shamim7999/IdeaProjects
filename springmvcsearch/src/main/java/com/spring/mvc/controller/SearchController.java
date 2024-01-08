package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @RequestMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("name", "Shamim");
        return "home";
    }

    @RequestMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("name", "Shamim");
        return "home";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("querybox") String query) {
        String str="redirect:https://www.google.com/search?q="+query;
        if(query.isEmpty()) {
            return "redirect:/home";
        }
        return str;
    }
}
