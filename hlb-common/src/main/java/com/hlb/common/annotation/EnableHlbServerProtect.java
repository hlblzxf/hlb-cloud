package com.hlb.common.annotation;

import com.hlb.common.configure.HlbServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HlbServerProtectConfigure.class)
public @interface EnableHlbServerProtect {
}
