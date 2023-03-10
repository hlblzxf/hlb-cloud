package com.hlb.common.handler;

import com.hlb.common.entity.HlbResponse;
import com.hlb.common.utils.HlbUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HlbAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        HlbResponse hlbResponse = new HlbResponse();
        HlbUtil.makeResponse(response, MediaType.APPLICATION_JSON_VALUE,HttpServletResponse.SC_UNAUTHORIZED, hlbResponse.message("token 无效"));
    }
}
