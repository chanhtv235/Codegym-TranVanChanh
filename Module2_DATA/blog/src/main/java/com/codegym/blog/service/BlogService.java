package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findByID(Long id);

    void delete(Long id);

    Page<Blog> findAllByName(String s, Pageable pageable);
}
