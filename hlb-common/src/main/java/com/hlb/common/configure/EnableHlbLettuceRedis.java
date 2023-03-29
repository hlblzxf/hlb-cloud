package com.hlb.common.configure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HlbLettuceRedisConfigure.class)
public @interface EnableHlbLettuceRedis {
}
