package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("userName", "수바리");
        return "greetings";
    }

    @GetMapping("/bye")
    public String sayGoodBye(Model model) {
        model.addAttribute("userName", "수바리");
        return "goodBye";
    }
}
