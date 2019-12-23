package com.codegym.product_thymeleaf.service;

import com.codegym.product_thymeleaf.entity.Product;

public interface ProductService {
    float calculateDiscount(Product product);
}
