package com.hlb.common.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hlb.common.annotation.IsMobile;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class SystemUser implements Serializable {
    private static final long serialVersionUID = -4352868070794165001L;
    // 用户状态：有效
    public static final String STATUS_VALID = "1";
    // 用户状态：锁定
    public static final String STATUS_LOCK = "0";
    // 默认头像
    public static final String DEFAULT_AVATAR = "default.jpg";
    // 默认密码
    public static final String DEFAULT_PASSWORD = "1234qwer";
    // 性别男
    public static final String SEX_MALE = "0";
    // 性别女
    public static final String SEX_FEMALE = "1";
    // 性别保密
    public static final String SEX_UNKNOW = "2";
    /**
     * 用户 ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    @TableField("USERNAME")
    @Size(min = 4, max = 10, message = "{range}")
    private String username;
    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    @TableField("DEPT ID")
    private Long deptid;

    @TableField("EMAIL")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String email;

    @TableField("MOBILE")
    @IsMobile(message = "{mobile}")
    private String mobile;

    @TableField("STATUS")
    @NotBlank(message = "{required}")
    private String status;

    @TableField("CREATE TIME")
    private Date createTime;

    @TableField("MODIFY TIME")
    private Date modifyTime;

    @TableField("LAST LOGIN TIME")
    private Date lastLoginTime;

    @TableField("SSEX")
    @NotBlank(message = "{required}")
    private String sex;

    @TableField("AVATAR")
    private String avatar;
    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    @Size(max = 100, message = "{noMoreThan}")
    private String description;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;
    @TableField(exist = false)
    private String createTimeFrom;
    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;
    @TableField(exist = false)
    private String roleName;
}
