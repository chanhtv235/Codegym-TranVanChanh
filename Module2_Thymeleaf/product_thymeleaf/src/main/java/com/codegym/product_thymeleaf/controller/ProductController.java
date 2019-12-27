package com.codegym.product_thymeleaf.controller;

import com.codegym.product_thymeleaf.entity.Product;
import com.codegym.product_thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/product")
    public ModelAndView findAll(){
        return new ModelAndView("list","productList",productService.findAll());
    }
    @GetMapping("/product/create")
    public ModelAndView createForm(){
        return new ModelAndView("createForm","product",new Product());
    }
    @PostMapping("/product/create")
    public String saveCustomer(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 1000));
        productService.addProduct(product);
        redirect.addFlashAttribute("message", "Ban da them thanh cong");
        return "redirect:/product";
    }
    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") int id) {
        return new ModelAndView("deleteForm", "product", productService.findById(id));
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("message", "Ban da xoa thanh cong");
        return "redirect:/product";
    }
    @GetMapping("/product/info/{id}")
    public ModelAndView infoForm(@PathVariable("id") int id) {
        return new ModelAndView("infoForm", "product", productService.findById(id));
    }
//    @PostMapping("/product/info")
//    public String backToList(RedirectAttributes redirect) {
//        return "redirect:/product";
//    }
    @GetMapping("/product/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") int id) {
        return new ModelAndView("updateFrom", "product", productService.findById(id));
    }
    @PostMapping("/product/edit")
    public String update(Product customer, RedirectAttributes redirect) {
        productService.update(customer.getId(), customer);
        redirect.addFlashAttribute("message", "Ban da update thanh cong");
        return "redirect:/product";
    }
    @GetMapping("/product/search")
    public ModelAndView searchForm() {
        return new ModelAndView("searchFrom");
    }
    @PostMapping("/product/search")
    public ModelAndView search(@RequestParam(name = "name")String name) {
        return new ModelAndView("searchFrom","product",productService.search(name));
    }
}
