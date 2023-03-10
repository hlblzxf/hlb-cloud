package com.hlb.common.configure;

import com.hlb.common.handler.HlbAccessDeniedHandler;
import com.hlb.common.handler.HlbAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class HlbAuthExceptionConfigure {
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public HlbAccessDeniedHandler accessDeniedHandler() {
        return new HlbAccessDeniedHandler();
    }
    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public HlbAuthExceptionEntryPoint authenticationEntryPoint() {
        return new HlbAuthExceptionEntryPoint();
    }

}
