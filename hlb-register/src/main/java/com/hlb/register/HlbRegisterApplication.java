package com.hlb.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HlbRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbRegisterApplication.class, args);
    }

}
