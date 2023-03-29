package com.hlb.common.selector;

import com.hlb.common.configure.HlbAuthExceptionConfigure;
import com.hlb.common.configure.HlbOAuth2FeignConfigure;
import com.hlb.common.configure.HlbServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * import three annotation in one selector
 * @EnableHlbAuthExceptionHandler
 * @EnableHlbOauth2FeignClient
 * @EnableHlbServerProtect
 */
public class HlbCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                HlbAuthExceptionConfigure.class.getName(),
                HlbOAuth2FeignConfigure.class.getName(),
                HlbServerProtectConfigure.class.getName(),
        };
    }
}
