package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category/list")
    public ModelAndView listCatalog(Pageable pageable){
        Page<Category> categories= categoryService.findAll(pageable);
        return new ModelAndView("category/listCategory","categories",categories);
    }
    @GetMapping("/category/create")
    public ModelAndView creatForm(Pageable pageable){
        return new ModelAndView("category/createCategory","category",new Category());
    }
    @PostMapping("/category/create")
    public ModelAndView create(@ModelAttribute Category category){
        categoryService.save(category);
       ModelAndView modelAndView= new ModelAndView("createCategory","category",new Category());
       modelAndView.addObject("message","Ban da tao moi 1 category thanh cong");
        return modelAndView;
    }
    @GetMapping("/category/edit")
    public ModelAndView editForm(@RequestParam(value ="id" ) Long id){
        Category category = categoryService.findByID(id);
        if (category !=null){
            return new ModelAndView("category/editCatalog","category", category);
        }else {
            return new ModelAndView("category/erros404");
        }
    }
    @PostMapping("/category/edit")
    public ModelAndView update(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("category/editCatalog","category", category);
        modelAndView.addObject("message","Ban da update thanh cong");
        return modelAndView;
    }
    @GetMapping("/category/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Category category = categoryService.findByID(id);
        if (category !=null){
            return new ModelAndView("category/deleteCategory","category", category);
        }else {
            return new ModelAndView("category/erros404");
        }
    }
    @PostMapping("/category/delete")
    public String delete(@ModelAttribute Category category, RedirectAttributes ra) {
        categoryService.delete(category.getId());
        ra.addFlashAttribute("message", "Ban da delete thanh cong");
        return "redirect:/category/list";
    }
}
