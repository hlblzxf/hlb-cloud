package com.hlb.server.system;

import com.hlb.common.annotation.EnableHlbAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@EnableDiscoveryClient
@EnableHlbAuthExceptionHandler
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HlbServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbServerSystemApplication.class, args);
    }

}
