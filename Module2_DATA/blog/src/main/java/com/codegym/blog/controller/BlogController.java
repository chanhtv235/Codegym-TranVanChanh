package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categorys")
    public Page<Category> catalogs(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/blog/list")
    public ModelAndView listBlog(@RequestParam(value = "s") Optional<String> s, Pageable pageable) {
        Page<Blog> blogs;
        if (s.isPresent()) {
            if (s.get().equals("")) {
                blogs = blogService.findAll(pageable);
                return new ModelAndView("blog/listBlog", "blogs", blogs);
            }
            blogs = blogService.findAllByName(s.get(), pageable);
            ModelAndView modelAndView = new ModelAndView("blog/listBlog", "blogs", blogs);
            modelAndView.addObject("s", s.get());
            return modelAndView;
//        }else if(s.get().equals("")){
//            blogs=blogService.findAll(pageable);
//            return new ModelAndView("blog/listBlog","blogs",blogs);
        } else {
            blogs = blogService.findAll(pageable);
            return new ModelAndView("blog/listBlog", "blogs", blogs);
        }

    }

    @GetMapping("/blog/create")
    public ModelAndView createBlogForm() {
        ModelAndView modelAndView = new ModelAndView("blog/createBlog", "blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView save(@ModelAttribute(value = "blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/createBlog", "blog", new Blog());
        modelAndView.addObject("message", "Bạn đã tạo mới thành công một Blog");
        return modelAndView;
    }

    @GetMapping("/blog/edit")
    public ModelAndView editBlogForm(@RequestParam(value = "id") Long id) {
        Blog blog = blogService.findByID(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/editBlog");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("blog/erros404");
            return modelAndView;
        }
    }

    @PostMapping("/blog/edit")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/editBlog", "blog", blog);
        modelAndView.addObject("message", "Bạn đã sửa thông tin thành công ");
        return modelAndView;
    }

    @GetMapping("/blog/delete/{id}")
    public ModelAndView deleteBlogForm(@PathVariable(value = "id") Long id) {
        Blog blog = blogService.findByID(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/deleteBlog", "blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("blog/erros404", "blog", blog);
            return modelAndView;
        }
    }

    @PostMapping("/blog/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes ra) {
        blogService.delete(blog.getId());
        ra.addFlashAttribute("message", "Bạn đã xóa thành công 1 Blog");
        return "redirect:/blog/list";
    }

    @GetMapping("blog/info/{id}")
    public ModelAndView info(@PathVariable Long id) {
        Blog blog = blogService.findByID(id);
        return new ModelAndView("blog/infoBlog", "blog", blog);
    }
}
