package com.hlb.auth.properties;

import lombok.Data;

@Data
public class HlbClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
