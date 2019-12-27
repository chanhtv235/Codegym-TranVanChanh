package com.codegym.customer_data.controllers;

import com.codegym.customer_data.models.Customer;
import com.codegym.customer_data.models.Province;
import com.codegym.customer_data.service.CustomerService;
import com.codegym.customer_data.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @Autowired
  ProvinceService provinceService;
  @ModelAttribute("provinces")
  public Iterable<Province> provinces(){
    return provinceService.findAll();
  }

  @GetMapping("/customer/search")
  public ModelAndView listCustomer(@RequestParam (value = "s1") String search, Pageable pageable) {
    Page<Customer> customers;
      customers=customerService.findByFristName(search,pageable);
    ModelAndView modelAndView=new ModelAndView("customer/listFind", "customers", customers);
    modelAndView.addObject("s2",search);
    return modelAndView;
  }
  @GetMapping("/customer/list")
  public ModelAndView listCustomer(Pageable pageable) {
    Page<Customer> customers;
     customers= customerService.findAll(pageable);
    ModelAndView modelAndView=new ModelAndView("customer/list", "customers", customers);
    return modelAndView;
    }


//  @GetMapping("/customer/list")
//  public ModelAndView listCustomer(@RequestParam ("s") Optional<String> s, Pageable pageable) {
//    Page<Customer> customers;
//    if (s.isPresent()){
//        customers=customerService.findByFristName(s.get(),pageable);
//    }else {
//     customers= customerService.findAll(pageable);
//    }
//    ModelAndView modelAndView=new ModelAndView("customer/list", "customers", customers);
//    return modelAndView;
//  }

  @GetMapping("/customer/create")
  public ModelAndView showCreateForm() {
    ModelAndView modelAndView = new ModelAndView("customer/create");
    modelAndView.addObject("customer", new Customer());
    return modelAndView;
  }
  @PostMapping("/customer/create")
  public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
    customerService.save(customer);

    ModelAndView modelAndView = new ModelAndView("customer/create");
    modelAndView.addObject("customer", new Customer());
    modelAndView.addObject("message", "New customer created successfully");
    return modelAndView;
  }
  @GetMapping("/customer/edit/{id}")
  public ModelAndView showEditForm(@PathVariable Long id){
    Customer customer = customerService.findById(id);
    if(customer != null) {
      ModelAndView modelAndView = new ModelAndView("customer/edit");
      modelAndView.addObject("customer", customer);
      return modelAndView;
    }else {
      ModelAndView modelAndView = new ModelAndView("customer/error404");
      return modelAndView;
    }
  }
  @PostMapping("/customer/edit")
  public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
    customerService.save(customer);
    ModelAndView modelAndView = new ModelAndView("customer/edit");
    modelAndView.addObject("customer", customer);
    modelAndView.addObject("message", "Customer updated successfully");
    return modelAndView;
  }
  @GetMapping("/customer/delete/{id}")
  public ModelAndView showDeleteForm(@PathVariable Long id){
    Customer customer = customerService.findById(id);
    if(customer != null) {
      ModelAndView modelAndView = new ModelAndView("customer/delete");
      modelAndView.addObject("customer", customer);
      return modelAndView;
    }else {
      ModelAndView modelAndView = new ModelAndView("customer/error404");
      return modelAndView;
    }
  }

  @PostMapping("/customer/delete")
  public String deleteCustomer(@ModelAttribute("customer") Customer customer){
    customerService.remove(customer.getId());
    return "redirect:/customer/list";
  }

}
