package io.github.liketic.spring.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("io.github.liketic.spring.user")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
