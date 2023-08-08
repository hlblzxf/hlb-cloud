package com.hlb.common.configure;

import com.hlb.common.entity.HlbConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;


/**
 * 因为Feign在调用远程服务的时候，
 * 并不会帮我们把原HTTP请求头部的内容也携带上，
 * 所以访问febs-server system的 /hello 服务的时候，请求头部没有访问
 */
public class HlbOAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 添加 Zuul Token
            String zuulToken = new String(Base64Utils.encode(HlbConstant.ZUUL_TOKEN_VALUE.getBytes()));
            requestTemplate.header(HlbConstant.ZUUL_TOKEN_HEADER, zuulToken);
            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            // 添加 authorization 访问令牌
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }

}
