package com.codegym.demo_create_project_spring_boot.service.impl;

import com.codegym.demo_create_project_spring_boot.entity.Persion;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersionServiceimpl implements PersionService {
    private static Map<Integer, Persion> map = new HashMap<>();

    static {
        map.put(1,new Persion(1,"Chanh","KonTum"));
        map.put(2,new Persion(2,"Dung","NgheAn"));
        map.put(3,new Persion(3,"Huy","QuangNam"));
    }

    @Override
    public List<Persion> FindAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void add(Persion persion) {
        map.put(persion.getId(),persion);
    }
}
