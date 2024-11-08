package ru.t1.demo.util;

import org.springframework.stereotype.Component;
import ru.t1.demo.dto.UserDto;
import ru.t1.demo.entity.User;

@Component
public class UserMapper {

    public static UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .fullAddress(entity.getFullAddress())
                .age(entity.getAge())
                .gender(entity.getGender())
                .build();
    }

    private UserMapper() {
    }
}
