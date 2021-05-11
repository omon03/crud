package com.crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {}
