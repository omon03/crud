package com.crud.dao;

import java.util.List;

import com.crud.model.User;

public interface UserDao {
    List<User> getAll();
    User showUserById(Long id);
    void save(User user);
    void update(Long id, User userUpdated);
    void delete(Long id);
}
