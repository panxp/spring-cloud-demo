package org.micro.user2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("com.micro.user2.entity")
@EnableEurekaClient
public class UserApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication2.class, args);
    }
}

