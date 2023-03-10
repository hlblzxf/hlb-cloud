package com.hlb.server.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HlbServerSystemNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbServerSystemNewApplication.class, args);
    }

}
