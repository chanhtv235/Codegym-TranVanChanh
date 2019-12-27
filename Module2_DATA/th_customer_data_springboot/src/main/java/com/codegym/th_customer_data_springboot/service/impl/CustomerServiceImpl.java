package com.codegym.th_customer_data_springboot.service.impl;

import com.codegym.th_customer_data_springboot.model.Customer;
import com.codegym.th_customer_data_springboot.repository.CustomerRepository;
import com.codegym.th_customer_data_springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public Iterable<Customer> findAll() {
//        return customerRepository.findAll();
//    }

//    @Override
//    public Customer findById(Long id) {
//        return customerRepository.findById(id).orElse(null);
//    }
//

//    @Override
//    public Customer findById(Long id) {
//        return (Customer) customerRepository.findById(id);
//    }
//
//    @Override
//    public void save(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public void remove(Long id) {
//        customerRepository.remove(id);
//    }
}
