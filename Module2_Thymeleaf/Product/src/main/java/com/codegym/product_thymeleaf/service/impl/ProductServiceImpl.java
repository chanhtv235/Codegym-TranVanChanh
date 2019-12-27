package com.codegym.product_thymeleaf.service.impl;

import com.codegym.product_thymeleaf.entity.Product;
import com.codegym.product_thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public float calculateDiscount(Product product) {
        return (float) (product.getPrice() * product.getDiscount() * 0.01);
    }
}
