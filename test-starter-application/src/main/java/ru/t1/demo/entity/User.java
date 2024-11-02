package ru.t1.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "usr")
@Entity
public class User {

    @Id
    @UuidGenerator
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String fullAddress;

    @Column
    private Integer age;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private UserGender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(fullAddress, user.fullAddress) && Objects.equals(age, user.age) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fullAddress, age, gender);
    }
}