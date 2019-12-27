package com.codegym.product_thymeleaf.service.impl;

import com.codegym.product_thymeleaf.entity.Product;
import com.codegym.product_thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    public static Map<Integer,Product> map =new HashMap<>();
    static {
        map.put(1,new Product(1,"Smartphone",100,"VietNam"));
        map.put(2,new Product(2,"LaptopVo",100,"Singapor"));
        map.put(3,new Product(3,"Ipad",100,"USA"));
        map.put(4,new Product(4,"Computer",100,"Japan"));
    }
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void addProduct(Product product) {
        map.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public void update(int id, Product customer) {
        map.put(id,customer);
    }

    @Override
    public Product search(String name) {
        List<Product> list = new ArrayList<>(map.values());
        Product product1=null;
        for (Product product: list) {
            if (product.getName().equals(name)){
                product1= product;
            }
        }
        return product1;
    }
}
