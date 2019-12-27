package com.codegym.customer_data.service.impl;

import com.codegym.customer_data.models.Customer;
import com.codegym.customer_data.repository.CustomerRepository;
import com.codegym.customer_data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
