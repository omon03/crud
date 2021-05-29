package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dao.UserDaoImpl;
import com.crud.model.User;
import com.crud.service.UserServiceImpl;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserServiceImpl userService;

    public UsersController() { }

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    /**
//     * Отображение всех юзеров по адресу /users
//     * @param model для передачи данных в страницу
//     * @return страница с таблицей users
//     */
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users", userService.showAllUsers());
//        return "/users/index";
//    }

    /**
     * Отображение одного юзера по id
     * @param id идентификатор юзера
     * @param model для передачи данных в страницу
     * @return страница для отображения user
     */
    @RequestMapping("/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/shower";
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "/users/new";
//    }

//    @PostMapping()
//    public String createUser(@ModelAttribute("user") @Valid User user,
//                             BindingResult bindingResult) throws Exception {
//        if (bindingResult.hasErrors()) {
//            // при вводе неправильных данных.
//            // См. аннотации полей класса User
//            return "/users/new";
//        }
//        userService.saveUser(user);
//        return "redirect:/users";
//    }

//    @GetMapping("/{id}/edit")
//    public String editUser(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "/users/edit";
//    }

//    @PostMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") @Valid User user,
//                             BindingResult bindingResult,  // указывать сразу после проверяемого объекта!
//                             @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors()) {
//            // при вводе неправильных данных.
//            // См. аннотации полей класса User
//            return "/users/edit";
//        }
//        userService.updateUser(id, user);
//        return "redirect:/users";
//    }

//    @GetMapping("/{id}/delete")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/users";
//    }
}
