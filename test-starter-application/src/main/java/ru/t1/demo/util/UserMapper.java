package ru.t1.demo.util;

import org.springframework.stereotype.Component;
import ru.t1.demo.dto.UserDto;
import ru.t1.demo.entity.User;

@Component
public class UserMapper {

    public static User toEntity(UserDto userDto) {
        return User.builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .fullAddress(userDto.fullAddress())
                .age(userDto.age())
                .gender(userDto.gender())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .fullAddress(user.getFullAddress())
                .age(user.getAge())
                .gender(user.getGender())
                .build();
    }

    private UserMapper() {
    }
}
