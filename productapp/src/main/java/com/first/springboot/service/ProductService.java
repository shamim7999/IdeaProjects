package com.first.springboot.service;

import com.first.springboot.model.Product;

import java.util.List;


public interface ProductService {
    public void addProduct(Product product);

    public List<Product> allProducts();

    public void deleteProduct(int productId);

    public Product getProductById(int productId);
}
