package com.hlb.server.system;

import com.hlb.common.annotation.HlbCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableDiscoveryClient
@SpringBootApplication
@HlbCloudApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.hlb.server.system.mapper")
@EnableTransactionManagement
public class HlbServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbServerSystemApplication.class, args);
    }

}
