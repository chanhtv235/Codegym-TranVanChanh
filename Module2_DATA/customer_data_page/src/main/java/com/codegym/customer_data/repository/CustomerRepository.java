package com.codegym.customer_data.repository;

import com.codegym.customer_data.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
   Page<Customer> findByFirstName(String firstName,Pageable pageable);
    //Page<Customer> findByFirstName(String firstName, Pageable pageable);

}
