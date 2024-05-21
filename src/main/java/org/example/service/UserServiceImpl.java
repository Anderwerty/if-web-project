package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.exception.EmailFormatException;
import org.example.service.exception.NameFormatException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final User EMPTY_USER = new User();

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String name, String email) {
        // validate name, email
        if (name == null) { // check regex
            throw new NameFormatException("your message");
        }
        if (email == null || !email.contains("@")) {
            throw new EmailFormatException();
        }

        // email is not used

        userRepository.findByEmail(email).ifPresent((u) -> {
            throw new IllegalArgumentException();
        });
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(EMPTY_USER);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
