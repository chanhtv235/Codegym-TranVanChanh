package com.codegym.demo_create_project_spring_boot.controllers;

import com.codegym.demo_create_project_spring_boot.entity.Persion;
import com.codegym.demo_create_project_spring_boot.service.impl.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class persionController {
    @Autowired
    PersionService persionService;
    @GetMapping("")
    public ModelAndView getListAll(){
        return new ModelAndView("list","persons",persionService.FindAll());
    }
    @GetMapping("/addPerson")
    public ModelAndView viewAddPerson(){
        return new ModelAndView("create","person",new Persion());
    }
//    @PostMapping("/addPerson")
//    public ModelAndView addPerson(Persion person){
//        person.setId ((int)(Math.random()*1000));
//        persionService.add(person);
//        return new ModelAndView("list","persons",persionService.FindAll());
//    }
    @PostMapping("/addPerson")
    public String addPerson(Persion person, RedirectAttributes redirect){
        person.setId ((int)(Math.random()*1000));
        persionService.add(person);
        redirect.addFlashAttribute("message","Tao moi thanh cong");
        return "redirect:/";
    }

}
