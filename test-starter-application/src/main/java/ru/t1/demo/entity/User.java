package ru.t1.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usr")
@Entity
public class User {

    @Id
    @UuidGenerator
    @Setter(AccessLevel.NONE)
    @Column(updatable = false, unique = true, nullable = false, name = "id")
    private UUID id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "full_address")
    private String fullAddress;

    @Column(nullable = false, name = "age")
    private Integer age;

    @Column(nullable = false, name = "gender")
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(updatable = false, nullable = false, name = "created_at")
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false,name = "updated_at")
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(fullAddress, user.fullAddress) && Objects.equals(age, user.age) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, fullAddress, age, gender);
    }
}
