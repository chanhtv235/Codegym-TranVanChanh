package com.codegym.customer_thymeleaf.service;

import com.codegym.customer_thymeleaf.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
