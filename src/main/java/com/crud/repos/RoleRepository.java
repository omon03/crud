package com.crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}
