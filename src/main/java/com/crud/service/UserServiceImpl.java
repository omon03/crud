package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.dao.UserDaoImpl;
import com.crud.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.showUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.getAll();
    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.update(id, user);
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" + "userDao=" + userDao + '}';
    }
}
