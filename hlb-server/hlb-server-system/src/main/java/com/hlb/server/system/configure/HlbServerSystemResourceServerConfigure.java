package com.hlb.server.system.configure;

import com.hlb.common.handler.HlbAccessDeniedHandler;
import com.hlb.common.handler.HlbAuthExceptionEntryPoint;
import com.hlb.server.system.properties.HlbServerSystemProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@SuppressWarnings("ALL")
@Configuration
@EnableResourceServer
public class HlbServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private HlbAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private HlbAuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    private HlbServerSystemProperties properties;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

}