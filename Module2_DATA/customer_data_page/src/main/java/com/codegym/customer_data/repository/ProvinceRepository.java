package com.codegym.customer_data.repository;

import com.codegym.customer_data.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
