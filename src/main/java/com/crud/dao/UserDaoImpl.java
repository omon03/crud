package com.crud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.User;

@Repository
public class UserDaoImpl implements UserDao {
//    private static Long userCount = 0L;
//    private final List<User> users;
//
//    {
//        users = new ArrayList<>();
//        users.add(new User(++userCount, "Sam", 20, "sam@mail.ru"));
//        users.add(new User(++userCount, "Bob", 20, "bob@mail.ru"));
//        users.add(new User(++userCount, "Tom", 20, "tom@mail.ru"));
//        users.add(new User(++userCount, "Kat", 20, "kat@mail.ru"));
//    }

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        TypedQuery<User> query = entityManager.createQuery("select * from users", User.class);
        return query.getResultList();
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
        User user = entityManager.find(User.class, id);
        user.setName(userUpdated.getName());
        user.setAge(userUpdated.getAge());
        user.setEmail(userUpdated.getEmail());
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
