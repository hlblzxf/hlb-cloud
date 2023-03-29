package com.hlb.auth;

import com.hlb.common.annotation.HlbCloudApplication;
import com.hlb.common.configure.EnableHlbLettuceRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@HlbCloudApplication
@MapperScan("com.hlb.auth.mapper")
@EnableHlbLettuceRedis
public class HlbAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbAuthApplication.class, args);
    }

}
