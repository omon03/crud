package com.crud.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(@NotEmpty(message = "Not be empty") @Size(min = 3, max = 30, message = "ERROR") String userName);

    User findByUsername(String username);
}
