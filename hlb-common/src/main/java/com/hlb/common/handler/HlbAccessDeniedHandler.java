package com.hlb.common.handler;

import com.hlb.common.entity.HlbResponse;
import com.hlb.common.utils.HlbUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HlbAccessDeniedHandler implements AccessDeniedHandler {
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        HlbResponse hlbResponse = new HlbResponse();
        HlbUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_FORBIDDEN, hlbResponse.message("没有权限 访问该资源"));
    }
}
