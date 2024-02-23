package com.adeleon.ecommerce.service;

import com.adeleon.ecommerce.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
