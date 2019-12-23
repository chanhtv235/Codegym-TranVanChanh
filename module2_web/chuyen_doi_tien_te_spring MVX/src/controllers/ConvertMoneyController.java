package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {
    @GetMapping("/convert")
    public String CreatForm(@RequestParam String dollar,Model model){
        model.addAttribute("dollar",dollar);
        return "display";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam (name="usd")String usd,Model model){
        float vnd = Float.parseFloat(usd)*23000;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "display";
    }
}
