package com.codegym.customer_data.controllers;

import com.codegym.customer_data.models.Province;
import com.codegym.customer_data.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerProvince {
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/province/list")
    public ModelAndView listProvinces(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/listProvince");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }
    @GetMapping("/province/create")
    public ModelAndView creatFormProvince(){
        return new ModelAndView("province/createProvince","product",new Province());
    }
    @PostMapping("/province/create")
    public String saveProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
//        ModelAndView modelAndView = new ModelAndView("province/createProvince");
//        modelAndView.addObject("province", new Province());
//        modelAndView.addObject("message", "New province created successfully");
        redirectAttributes.addFlashAttribute("message","New province created successfully");
        return "redirect:/province/create";
    }
    @GetMapping("/province/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Province province = provinceService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("province/editProvince");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("province/edit")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("province/editProvince");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }
    @GetMapping("/province/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Province province = provinceService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("province/deleteProvince");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/province/delete")
    public String deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        return "redirect:/province/list";
    }

}
