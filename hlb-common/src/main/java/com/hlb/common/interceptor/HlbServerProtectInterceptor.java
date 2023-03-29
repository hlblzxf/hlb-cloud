package com.hlb.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hlb.common.entity.HlbConstant;
import com.hlb.common.entity.HlbResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HlbServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(HlbConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(HlbConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            HlbResponse hlbResponse = new HlbResponse();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(hlbResponse.message("Please get resources through the gateway")));
            return false;
        }
    }
}
