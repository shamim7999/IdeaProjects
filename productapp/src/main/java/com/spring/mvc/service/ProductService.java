package com.spring.mvc.service;

import com.spring.mvc.model.Product;
import com.spring.mvc.model.Registered;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public List<Product> allProducts();

    public void deleteProduct(int productId);

    public Product getProduct(int productId);

    public void registerUser(Registered registered);
}
