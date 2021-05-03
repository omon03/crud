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
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    /**
     * Отображение всех юзеров по адресу /users
     * @param model для передачи данных в страницу
     * @return страница с таблицей users
     */
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDaoImpl.getAll());
        return "/users/index";
    }

    /**
     * Отображение одного юзера по id
     * @param id идентификатор юзера
     * @param model для передачи данных в страницу
     * @return страница для отображения user
     */
    @RequestMapping("/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userDaoImpl.showUserById(id));
        return "/users/shower";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // при вводе неправильных данных.
            // См. аннотации полей класса User
            return "/users/new";
        }
        userDaoImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userDaoImpl.showUserById(id));
        return "/users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,  // указывать сразу после проверяемого объекта!
                             @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            // при вводе неправильных данных.
            // См. аннотации полей класса User
            return "/users/edit";
        }
        userDaoImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userDaoImpl.delete(id);
        return "redirect:/users";
    }
}
