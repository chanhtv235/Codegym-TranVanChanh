package com.codegym.customer_data.service;

import com.codegym.customer_data.models.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();
    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);
}
