package com.hlb.common.annotation;

import com.hlb.common.configure.HlbAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HlbAuthExceptionConfigure.class)
public @interface EnableHlbAuthExceptionHandler {
}
