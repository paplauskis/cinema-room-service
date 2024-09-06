package org.example.cinemaroomservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.example.cinemaroomservice")
public class CinemaRoomServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaRoomServiceApplication.class, args);
    }

}
