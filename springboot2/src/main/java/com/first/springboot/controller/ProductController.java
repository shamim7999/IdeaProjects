package com.first.springboot.controller;

import com.first.springboot.helpers.ModelTransporter;
import com.first.springboot.model.Product;
import com.first.springboot.model.Registered;
import com.first.springboot.service.ProductService;
import com.first.springboot.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
        model.addAttribute("product", this.productService.getProductById(productId));
        return "update_product_form";
    }

}
