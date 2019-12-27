package com.codegym.customer_data.service;

import com.codegym.customer_data.models.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    void save(Province province);

    Province findById(Long id);

    void remove(Long id);
}
