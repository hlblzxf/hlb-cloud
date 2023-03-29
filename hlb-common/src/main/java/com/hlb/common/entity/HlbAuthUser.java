package com.hlb.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = true)
public class HlbAuthUser extends User{
    private static final long serialVersionUID = -6411066541689297219L;
    private Long userId;
    private String avatar;
    private String email;
    private String mobile;
    private String sex;
    private Long deptId;
    private String deptName;
    private String roleId;
    private String roleName;
    private Date lastLoginTime;
    private String description;
    private String status;
    public HlbAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    public HlbAuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                       Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
