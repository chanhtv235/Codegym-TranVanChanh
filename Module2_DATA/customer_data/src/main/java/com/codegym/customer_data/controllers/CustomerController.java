package com.codegym.customer_data.controllers;

import com.codegym.customer_data.models.Customer;
import com.codegym.customer_data.models.Province;
import com.codegym.customer_data.service.CustomerService;
import com.codegym.customer_data.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

  @GetMapping("/customer/list")
  public ModelAndView create() {
    return new ModelAndView("customer/list", "customers", customerService.findAll());
  }

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
