package org.example.repository;

import org.example.entity.User;

import java.util.List;
import java.util.Optional;

//CRUD
public interface UserRepository {

    User save(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

}
