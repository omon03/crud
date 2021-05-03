package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/")
    public String getIndexPage(Model model) {
        return "test/index";
    }

    @RequestMapping("/home")
    public String getHomePage() {
        return "test/home";
    }
}
