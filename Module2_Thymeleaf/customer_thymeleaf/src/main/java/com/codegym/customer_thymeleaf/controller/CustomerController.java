package com.codegym.customer_thymeleaf.controller;

import com.codegym.customer_thymeleaf.entity.Customer;
import com.codegym.customer_thymeleaf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ModelAndView findAll() {
        return new ModelAndView("listCustomer", "listCustomer", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("createCustomerForm", "customer", new Customer());
    }

    @PostMapping("/create")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 1000));
        customerService.addCustomer(customer);
        redirect.addFlashAttribute("message", "Ban da them thanh cong");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") int id) {
        return new ModelAndView("editCustomer", "customer", customerService.getCustomer(id));
    }

    @PostMapping("/edit")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("message", "Ban da update thanh cong");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") int id) {
        return new ModelAndView("deleteCustomer", "customer", customerService.getCustomer(id));
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Ban da xoa thanh cong");
        return "redirect:/";
    }
}
