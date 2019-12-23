package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//public class GreetingController {
//    @GetMapping("/greeting")
//    public String greeting(){
//        return "hello";
//    }
//}
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam String tenkhach1,String tenkhach3, Model modle){
        modle.addAttribute("chanh", tenkhach1);
        modle.addAttribute("chanh2", tenkhach3);
        return "helloParamater";
    }
    @PostMapping("/greeting")
    public String greeting2(@RequestParam(name = "ten1") String tenkhach1,@RequestParam(name = "ten2")String tenkhach2, Model modle){
        modle.addAttribute("chanh", tenkhach1+ " post");
        modle.addAttribute("chanh2", tenkhach2+ " post");
        return "helloParamater";
    }
}
