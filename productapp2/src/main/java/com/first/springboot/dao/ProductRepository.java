package com.first.springboot.dao;

import com.first.springboot.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "select * from Product", nativeQuery = true)
    public List<Product> allProducts();
}
