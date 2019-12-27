package com.codegym.customer_data.service;

import com.codegym.customer_data.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);

    Page<Customer> findByFristName(String firstName,Pageable pageable);
}
