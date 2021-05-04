package com.crud.service;

import java.util.List;

import com.crud.model.User;

public interface UserService {
    User getUserById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
    List<User> showAllUsers();
    void updateUser(Long id, User user);
}
