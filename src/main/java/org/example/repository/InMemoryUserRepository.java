package org.example.repository;

import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private static int counter = 0;
    private final Map<Integer, User> idToUser = new HashMap<>();

    {
        User user1 = new User();
        user1.setName("Oleksandr");
        user1.setEmail("oleksandr@gmail.com");
        user1.setId(++counter);

        User user2 = new User();
        user2.setName("Petro");
        user2.setEmail("petro@gmail.com");
        user2.setId(++counter);

        idToUser.put(user1.getId(), user1);
        idToUser.put(user2.getId(), user2);
    }

    @Override
    public User save(User user) {
        int userId = ++counter;
        user.setId(userId);
        idToUser.put(userId, user);

        return user;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(idToUser.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return idToUser.values().stream()
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(idToUser.values());
    }
}
