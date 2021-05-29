package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.User;
import com.crud.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserServiceImpl userService;

    public AdminController() { }

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showTableOfUsers(Model model) {
        System.out.println("Access admin to page users");
        List<User> users = userService.showAllUsers();
        System.out.println(users);
        model.addAttribute("users", users);
        return "/admin/index";
    }

    @GetMapping("/user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/admin/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) throws Exception {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/shower";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/admin/edit";
    }

    @PostMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}/delete")
    public String delete(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}