package com.hlb.auth.controller;

import com.hlb.auth.service.ValidateCodeService;
import com.hlb.common.entity.HlbResponse;
import com.hlb.common.exception.HlbAuthException;
import com.hlb.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;


    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }
    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
    @DeleteMapping("signout")
    public HlbResponse signout(HttpServletRequest request) throws HlbAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replaceIgnoreCase(authorization, "bearer ", "");
        HlbResponse febsResponse = new HlbResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new HlbAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

}
