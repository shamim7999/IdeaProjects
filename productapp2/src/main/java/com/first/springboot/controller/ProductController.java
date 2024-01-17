package com.first.springboot.controller;

import com.first.springboot.helpers.HibernateSessionFactory;
import com.first.springboot.helpers.ModelTransporter;
import com.first.springboot.model.Product;
import com.first.springboot.model.Registered;

import com.first.springboot.service.ProductService;
import com.first.springboot.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("title", "Add Product");
        return "add_product_form";
    }

    @RequestMapping(path = "/processProductForm", method = RequestMethod.POST)
    public String processProductForm(@ModelAttribute Product product) {
        System.out.println(product);
        this.productService.addProduct(product);
        return "redirect:/add-product";
    }

    @RequestMapping("/all-products")
    public String allProducts(Model model) {
        model.addAttribute("productList", this.productService.allProducts());
        model.addAttribute("title", "All Products");
        return "show_products";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/all-products");
        this.productService.deleteProduct(productId);
        return redirectView;
    }

    @RequestMapping("updateProduct/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, Model model) {
        //model.addAttribute("product", this.productService.getProduct(productId));
        return "update_product_form";
    }

    @RequestMapping("/login")
    public String login() {
        return "testPage";
    }





    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public String loginHandler(@RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword,
                               Model model, HttpServletRequest req) {

        List<Registered> list = this.registerService.findRegisteredUsers(userName,
                userPassword);

        String red = req.getContextPath();

        if(list.isEmpty()) {
            //return redirectView;
            //return "redirect:/"+red+"/register";
            return "redirect:/register";
        }
        HttpSession session1 = req.getSession();
        session1.setAttribute("name", userName);
        model.addAttribute("name", userName);
        ModelTransporter.setModel(model);
        return "home";
    }
    @RequestMapping(path = "/registerHandler", method = RequestMethod.POST)
    public String registerHandler(@ModelAttribute Registered registered) {

        if(!registered.getUserPassword().equals(registered.getUserConfirmPassword()) ) {
            return "register";
        }

        List<Registered> list = this.registerService.findRegisteredUsers(registered.getUserName(),
                registered.getUserPassword());
        if(!list.isEmpty())
            return "register";
        //System.out.println(registered);
        this.registerService.registerUser(registered);
        return "login";
    }
}
