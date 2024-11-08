package ru.t1.demo.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class UserConfig {

    @Bean
    Random random() {
        return new Random();
    }

    @Bean
    Faker faker() {
        return new Faker();
    }
}
