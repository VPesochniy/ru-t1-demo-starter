package ru.t1.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.demo.entity.User;
import ru.t1.demo.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(UUID userId) {

        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No such user with " + userId + " id."));
    }

    public void deleteUserById(UUID userId) {

        User foundUser = getUserById(userId);
        userRepository.delete(foundUser);
    }

    public User addUser(User user) {

        return userRepository.save(user);
    }
}
