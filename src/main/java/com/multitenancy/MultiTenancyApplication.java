package com.multitenancy;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MultiTenancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiTenancyApplication.class, args);
        Flyway flyway = Flyway
                .configure()
                .locations("classpath:db/migration")
                .schemas("public")
                .dataSource("jdbc:postgresql://localhost:7076/multi_tenancy", "multi", "multi")
                .cleanDisabled(false)
                .load();
        flyway.migrate();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
