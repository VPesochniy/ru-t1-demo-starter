package ru.t1.demo.dto;

import lombok.Builder;
import ru.t1.demo.entity.UserGender;

import java.util.UUID;

@Builder
public record UserDto(UUID id, String firstName, String lastName, String fullAddress, Integer age, UserGender gender) {
}
