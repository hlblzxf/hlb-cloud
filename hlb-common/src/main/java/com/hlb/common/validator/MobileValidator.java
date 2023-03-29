package com.hlb.common.validator;

import com.hlb.common.annotation.IsMobile;
import com.hlb.common.entity.RegexpConstant;
import com.hlb.common.utils.HlbUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {
    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return HlbUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;

        }
    }
}
