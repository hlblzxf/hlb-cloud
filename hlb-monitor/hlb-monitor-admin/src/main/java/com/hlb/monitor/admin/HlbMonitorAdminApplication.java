package com.hlb.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class HlbMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlbMonitorAdminApplication.class, args);
    }

}
