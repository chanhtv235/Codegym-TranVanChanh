package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String displayForm(){
        return "DictionaryForm";
    }
    @PostMapping("/dictionary")
    public String translate(@RequestParam(name = "txtSearch") String english, Model model){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String vietnames=dictionary.get(english);
        if (vietnames!=null){
            model.addAttribute("englishVietnames",english+":"+vietnames);
        }else {
            model.addAttribute("englishVietnames","Not Found");
        }
        return "DictionaryForm";
    }
}
