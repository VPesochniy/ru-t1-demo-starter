package ru.t1.demo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.t1.demo.aspect.HttpLoggingAspect;

@Configuration
@EnableConfigurationProperties(HttpLoggingProperties.class)
public class HttpLoggingAutoConfiguration {

    @Bean
    HttpLoggingProperties httpLoggingProperties(){
        return new HttpLoggingProperties();
    }

    @Bean
    HttpLoggingAspect httpLoggingAspect() {
        return new HttpLoggingAspect(httpLoggingProperties());
    }

}
