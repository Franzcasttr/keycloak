package com.food.keycloak.user;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String username);
}
