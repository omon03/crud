package com.crud.service;

import java.util.List;

import com.crud.model.User;

public interface UserService {
    User getUserById(Long id);
    User saveUser(User user) throws Exception;
    boolean deleteUserById(Long id);
    List<User> showAllUsers();
    User updateUser(Long id, User user);
}
