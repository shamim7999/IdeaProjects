package com.first.springboot.dao;

import com.first.springboot.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "select * from product", nativeQuery = true)
    public List<Product> allProducts();
}
