package com.experis.course.bestoftheyear.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("home")
    public String home(Model model) {
        String name = "Gianluca";
        model.addAttribute("title", name);
        return "home";
    }
}
