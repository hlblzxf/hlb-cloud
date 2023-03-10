package com.hlb.common.annotation;

import com.hlb.common.configure.HlbOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HlbOAuth2FeignConfigure.class)
public @interface EnableHlbOauth2FeignClient {

}
