package com.crud.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.model.User;
import com.crud.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class HelloController {

    private UserServiceImpl userService;

    public HelloController() {}

    @Autowired
    public HelloController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "hello/login";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String newUser() {
//        return "/admin/new";
//    }

    @RequestMapping(value = "hello-admin", method = RequestMethod.GET)
    public String printWelcomeAdmin(ModelMap model, Principal principal) {
        User user = (User)userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "/hello/hello-admin";
    }

    @RequestMapping(value = "hello-user", method = RequestMethod.GET)
    public String printWelcomeUser(ModelMap model, Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "/hello/hello-user";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "/hello/login";
    }
}
