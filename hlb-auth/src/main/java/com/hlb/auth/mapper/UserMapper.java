package com.hlb.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlb.common.entity.system.SystemUser;

public interface UserMapper  extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
