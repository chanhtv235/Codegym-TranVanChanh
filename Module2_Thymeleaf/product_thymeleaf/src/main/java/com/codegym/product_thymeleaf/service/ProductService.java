package com.codegym.product_thymeleaf.service;

import com.codegym.product_thymeleaf.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void addProduct(Product product);

    Product findById(int id);

    void remove(int id);

    void update(int id, Product customer);

    Product search(String name);
}
