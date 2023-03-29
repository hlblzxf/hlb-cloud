package com.hlb.auth.configure;

import com.hlb.auth.properties.HlbAuthProperties;
import com.hlb.common.handler.HlbAccessDeniedHandler;
import com.hlb.common.handler.HlbAuthExceptionEntryPoint;
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
public class HlbResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private HlbAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private HlbAuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    private HlbAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");

        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }


}
