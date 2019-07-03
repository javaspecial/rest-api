package com.net.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.net.world.controller", "com.net.world.serviceImpl"})
@EntityScan("com.net.world.model")
public class WorldApplication {

    public static void main(String[] args) {

        SpringApplication.run(WorldApplication.class, args);
    }

}
