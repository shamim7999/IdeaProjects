package com.first.springboot.controller;

import com.first.springboot.dao.RegisterRepository;
import com.first.springboot.helpers.ModelTransporter;
import com.first.springboot.model.Registered;
import com.first.springboot.service.ProductService;
import com.first.springboot.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private ProductService productService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public String loginHandler(@RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword, Model model, HttpServletRequest req) {
        List<Registered> registeredList = this.registerService.findRegisteredUsers(userName, userPassword);
        if(registeredList.isEmpty()) {
            return "register";
        }

        HttpSession session = req.getSession();
        session.setAttribute("userName", userName);

        System.out.println(userName);
        model.addAttribute("userName", userName);
        ModelTransporter.setModel(model);
        return "home";
    }


    @RequestMapping(path = "/logoutHandler", method = RequestMethod.POST)
    public String logoutHandler(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        session.invalidate(); // --->  Will remove all data.
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/registerHandler", method = RequestMethod.POST)
    public String registerHandler(@ModelAttribute Registered registered) {
        if(!registered.getUserPassword().equals(registered.getUserConfirmPassword()) ) {
            return "register";
        }

        Registered isAvailable = this.registerService.isUserNameAvailable(registered.getUserName());
        System.out.println(isAvailable);
        if(isAvailable != null) {
            return "register";
        }
        System.out.println(registered);
        this.registerService.registerUser(registered);

        System.out.println(registered.getUserName());
        return "login";
    }
}
