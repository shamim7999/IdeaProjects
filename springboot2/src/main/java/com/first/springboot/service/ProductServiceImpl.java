package com.first.springboot.service;

import com.first.springboot.dao.ProductRepository;
import com.first.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> allProducts() {
        return this.productRepository.allProducts();
    }

    @Override
    public void deleteProduct(int productId) {
        this.productRepository.deleteById(productId);
    }

    @Override
    public Product getProductById(int productId) {
        try {
            return this.productRepository.findById(productId).get();
        } catch (Exception e) {
            // Do nothing
        }
        return null;
    }
}
