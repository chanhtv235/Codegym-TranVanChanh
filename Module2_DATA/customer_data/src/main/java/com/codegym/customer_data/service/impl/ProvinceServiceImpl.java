package com.codegym.customer_data.service.impl;

import com.codegym.customer_data.models.Province;
import com.codegym.customer_data.repository.ProvinceRepository;
import com.codegym.customer_data.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Province findById(Long id) {
       return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
