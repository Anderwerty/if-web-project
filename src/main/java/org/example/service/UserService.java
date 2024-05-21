package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {

    User register(String name, String email);

    User findById(Integer id);

    List<User> findAll();
}
