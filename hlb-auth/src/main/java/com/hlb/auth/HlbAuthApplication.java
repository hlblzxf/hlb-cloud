package com.hlb.auth;

import com.hlb.common.annotation.EnableHlbAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHlbAuthExceptionHandler
public class HlbAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbAuthApplication.class, args);
    }

}
