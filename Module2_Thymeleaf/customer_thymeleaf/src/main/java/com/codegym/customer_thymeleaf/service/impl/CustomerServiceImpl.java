package com.codegym.customer_thymeleaf.service.impl;

import com.codegym.customer_thymeleaf.entity.Customer;
import com.codegym.customer_thymeleaf.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> map = new HashMap<>();

    static {
        map.put(1, new Customer(1, "Chanh", "chanh@gmail.com", "Kontum"));
        map.put(2, new Customer(2, "Dung", "dung@gmail.com", "NgheAn"));
        map.put(3, new Customer(3, "Toan", "toan@gmail.com", "DaNang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void addCustomer(Customer customer) {
        map.put(customer.getId(), customer);

    }

    @Override
    public Customer getCustomer(int id) {
        return map.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        map.put(id, customer);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }
}
