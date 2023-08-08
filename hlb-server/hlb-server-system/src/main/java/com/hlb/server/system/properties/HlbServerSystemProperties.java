package com.hlb.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:hlb-server-system.properties"})
@ConfigurationProperties(prefix = "hlb.server.system")
public class HlbServerSystemProperties {
    private String anonUrl;
    private HlbSwaggerProperties swagger = new HlbSwaggerProperties();
}
