package com.hlb.server.test;

import com.hlb.common.annotation.EnableHlbAuthExceptionHandler;
import com.hlb.common.annotation.EnableHlbOauth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableHlbAuthExceptionHandler
@EnableHlbOauth2FeignClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HlbServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbServerTestApplication.class, args);
    }

}
