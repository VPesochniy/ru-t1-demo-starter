package ru.t1.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.t1.demo.dto.UserDto;
import ru.t1.demo.entity.User;
import ru.t1.demo.service.UserService;
import ru.t1.demo.util.UserMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable UUID id) {
        User foundUser = userService.getUserById(id);
        return UserMapper.toDto(foundUser);
    }
}




