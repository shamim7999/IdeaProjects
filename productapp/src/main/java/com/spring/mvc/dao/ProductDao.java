package com.spring.mvc.dao;

import com.spring.mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product) {
        this.hibernateTemplate.saveOrUpdate(product);
    }
    @Transactional
    public void deleteProduct(int productId) {
        this.hibernateTemplate.delete(this.hibernateTemplate.load(Product.class, productId));
    }
    public List<Product> getProducts() {
       return this.hibernateTemplate.loadAll(Product.class);
    }
    public Product getProduct(int productId) {
        return this.hibernateTemplate.get(Product.class, productId);
    }
 }
