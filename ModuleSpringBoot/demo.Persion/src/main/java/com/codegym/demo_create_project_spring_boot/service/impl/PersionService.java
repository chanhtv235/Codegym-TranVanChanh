package com.codegym.demo_create_project_spring_boot.service.impl;

import com.codegym.demo_create_project_spring_boot.entity.Persion;

import java.util.List;

public interface PersionService {
    List<Persion> FindAll();

    void add(Persion persion);
}
