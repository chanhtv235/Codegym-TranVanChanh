package com.codegym.product_thymeleaf.controller;

import com.codegym.product_thymeleaf.entity.Product;
import com.codegym.product_thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ModelAndView displayProductForm() {
        return new ModelAndView("productForm", "product", new Product());
    }

    @PostMapping("/calculate")
    public ModelAndView calculateDiscount(Product product) {
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("product", product);
        modelAndView.addObject("discountAmount", productService.calculateDiscount(product));
        modelAndView.addObject("discountPrice", (product.getPrice() - productService.calculateDiscount(product)));
        return modelAndView;
    }
}
