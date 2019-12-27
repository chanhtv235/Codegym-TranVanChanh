package com.codegym.th_customer_data_springboot.controller;

import com.codegym.th_customer_data_springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
   private CustomerService customerService;
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("create");
        return modelAndView;
    }
}
