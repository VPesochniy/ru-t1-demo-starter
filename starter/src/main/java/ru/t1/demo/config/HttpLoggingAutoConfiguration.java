package ru.t1.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.t1.demo.aspect.HttpLoggingAspect;

@AutoConfiguration
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
