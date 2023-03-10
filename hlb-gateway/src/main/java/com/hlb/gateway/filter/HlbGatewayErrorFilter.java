package com.hlb.gateway.filter;

import com.hlb.common.entity.HlbResponse;
import com.hlb.common.utils.HlbUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class HlbGatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            HlbResponse hlbResponse = new HlbResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            hlbResponse = resolveExceptionMessage(message, serviceId, hlbResponse);
            HttpServletResponse response = ctx.getResponse();
            HlbUtil.makeResponse(response, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, hlbResponse);
            log.error("Zull sendError：{}", hlbResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private HlbResponse resolveExceptionMessage(String message, String serviceId, HlbResponse hlbResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return hlbResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return hlbResponse.message(serviceId + "服务不可用");
        }
        return hlbResponse.message("Zuul请求" + serviceId + "服务异常");
    }

}
