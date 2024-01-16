package com.spring.mvc.controller;

import com.spring.mvc.helpers.HibernateSessionFactory;
import com.spring.mvc.helpers.ModelTransporter;
import com.spring.mvc.model.Product;
import com.spring.mvc.model.Registered;
import com.spring.mvc.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ProductController {
    @Autowired
    private ProductService productService;

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
        model.addAttribute("product", this.productService.getProduct(productId));
        return "update_product_form";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public String loginHandler(@RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword,
                               Model model, HttpServletRequest req) {
        SessionFactory factory = HibernateSessionFactory.getSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        String query = "FROM Registered r WHERE r.userName =:u and r.userPassword =:p";

        String red = req.getContextPath();

        Query q = session.createQuery(query);
        q.setParameter("u", userName);
        q.setParameter("p", userPassword);
        transaction.commit();
        List<Registered> list = q.list();

        System.out.println(list);


        if(list.isEmpty()) {
            //return redirectView;
            return "redirect:/"+red+"/register";
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

        SessionFactory factory = HibernateSessionFactory.getSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        String query = "FROM Registered r WHERE r.userName =:u and r.userPassword =:p";
        Query q = session.createQuery(query);
        q.setParameter("u", registered.getUserName());
        q.setParameter("p", registered.getUserPassword());

        transaction.commit();

        List<Registered> list = q.list();
        if(!list.isEmpty())
            return "register";
        //System.out.println(registered);
        this.productService.registerUser(registered);
        return "login";
    }
}
