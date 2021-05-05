package com.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager
            .createQuery("select u from User u", User.class)
            .getResultList();
    }

    @Override
    public User showUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User userUpdated) {
        User user = showUserById(id);
        user.setName(userUpdated.getName());
        user.setAge(userUpdated.getAge());
        user.setEmail(userUpdated.getEmail());
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" + "entityManager=" + entityManager + '}';
    }
}
