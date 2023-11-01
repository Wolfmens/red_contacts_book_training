package org.application.config;

import org.application.InitialFileBase;
import org.application.User;
import org.application.Workers;
import org.springframework.context.annotation.*;

import java.util.HashSet;
import java.util.Set;


@Configuration
@PropertySource("classpath:application.properties")
@Profile("init")
public class FileListConfig {

    @Bean
    public Set<User> userList() {
        return new HashSet<>(initialBase().userList());
    }

    @Bean
    public Workers initialBase() {
        return new InitialFileBase();
    }
}
