package com.hlb.common.handler;

import com.hlb.common.entity.HlbResponse;
import com.hlb.common.exception.HlbAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HlbResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new HlbResponse().message("系统内部异常");
    }
    @ExceptionHandler(value = HlbAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HlbResponse handleFebsAuthException(HlbAuthException e) {
        log.error("系统错误", e);
        return new HlbResponse().message(e.getMessage());
    }
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public HlbResponse handleAccessDeniedException(){
        return new HlbResponse().message("没有权限访问该资源");
    }
}
