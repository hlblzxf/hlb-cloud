package com.hlb.common.annotation;

import com.hlb.common.selector.HlbCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HlbCloudApplicationSelector.class)
public @interface HlbCloudApplication {

}
