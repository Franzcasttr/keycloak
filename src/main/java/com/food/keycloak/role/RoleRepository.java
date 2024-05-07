package com.food.keycloak.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository{
    Optional<Role> findByName(String roleStudent);
}