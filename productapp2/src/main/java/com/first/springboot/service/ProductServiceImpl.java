package com.first.springboot.service;

import com.first.springboot.dao.ProductRepository;
import com.first.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    //@Autowired
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

}
