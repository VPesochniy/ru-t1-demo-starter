package ru.t1.demo;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.t1.demo.entity.User;
import ru.t1.demo.entity.UserGender;
import ru.t1.demo.repository.UserRepository;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
public class StarterApplication {

    private final Faker faker;
    private final Random random;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> IntStream.range(0, 10)
                .forEach(i -> {
                    int randomGender = random.nextInt(UserGender.values().length);
                    User user = User.builder()
                            .firstName(faker.name().firstName())
                            .lastName(faker.name().lastName())
                            .fullAddress(faker.address().fullAddress())
                            .age(random.nextInt(100) + 1)
                            .gender(UserGender.values()[randomGender])
                            .build();
                    userRepository.save(user);
                });
    }

}
