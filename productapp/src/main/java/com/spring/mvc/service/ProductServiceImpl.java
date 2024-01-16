package com.spring.mvc.service;

import com.spring.mvc.dao.ProductDao;
import com.spring.mvc.model.Product;
import com.spring.mvc.model.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Override
    public void addProduct(Product product) {
        this.productDao.createProduct(product);
    }

    @Override
    public List<Product> allProducts() {
        return this.productDao.getProducts();
    }

    @Override
    public void deleteProduct(int productId) {
        this.productDao.deleteProduct(productId);
    }

    @Override
    public Product getProduct(int productId) {
        return this.productDao.getProduct(productId);
    }

    @Override
    public void registerUser(Registered registered) {
        this.productDao.registerUser(registered);
    }
}
