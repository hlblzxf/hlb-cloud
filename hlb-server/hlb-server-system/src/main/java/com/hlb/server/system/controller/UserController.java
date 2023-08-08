package com.hlb.server.system.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hlb.common.entity.HlbResponse;
import com.hlb.common.entity.QueryRequest;
import com.hlb.common.entity.system.SystemUser;
import com.hlb.common.exception.HlbException;
import com.hlb.common.utils.HlbUtil;
import com.hlb.server.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public HlbResponse userList(QueryRequest queryRequest, SystemUser user) {
        Map<String, Object> dataTable = HlbUtil.getDataTable(userService.findUserDetail(user, queryRequest));
        return new HlbResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid SystemUser user) throws HlbException {
        try {
            this.userService.createUser(user);

        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new HlbException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(@Valid SystemUser user) throws HlbException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new HlbException(message);
        }
    }
    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws HlbException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new HlbException(message);
        }
    }


    @GetMapping("success")
    public void loginSuccess(HttpServletRequest request) {
        String currentUsername = HlbUtil.getCurrentUsername();
        // update last login time
        this.userService.updateLoginTime(currentUsername);
    }
}
