package com.codegym.th_customer_data_springboot.repository;

import com.codegym.th_customer_data_springboot.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
