package org.application.config;

import org.application.InitialRegularBase;
import org.application.User;
import org.application.Workers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppDefaultConfig {

    @Bean
    public Set<User> userList() {
        return new HashSet<>(initialBase().userList());
    }

    @Bean
    public Workers initialBase() {
        return new InitialRegularBase();
    }
}
