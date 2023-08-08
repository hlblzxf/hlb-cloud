package com.hlb.common.configure;

import com.hlb.common.interceptor.HlbServerProtectInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This Configure is used for adding gateway token validation interceptor to each micro servers
 */
public class HlbServerProtectConfigure implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor hlbServerProtectInterceptor() {

        return new HlbServerProtectInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("SpringConfigurationProxyMethods")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry gateway token validation interceptor
        registry.addInterceptor(hlbServerProtectInterceptor());
    }

}
