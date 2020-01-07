package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    Category findByID(Long id);

    void delete(Long id);
}
