package com.hlb.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hlb.common.entity.HlbAuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HlbUtil {
    /**
     * 设置响应
     *
     * @param response HttpServletResponse
     * @param contentType content-type
     * @param status http状态码
     * @param value 响应内容
     * @throws IOException IOException
     */
    public static void makeResponse(HttpServletResponse response, String contentType, int status, Object value) throws IOException {
        response.setContentType(contentType);
        response.setStatus(status);
        response.getOutputStream().write(JSONObject.toJSONString(value).getBytes());
    }

    /**
     * 封装前端分页表格所需数据
     *
     * @param pageInfo pageInfo
     * @return Map<String, Object>
     */
    public static Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("rows", pageInfo.getRecords());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    /**
     * 正则校验
     *
     * @param regex 正则表达式字符串
     * @param value 要匹配的字符串
     * @return 正则校验结果
     */
    public static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * 获取当前用户名称
     *
     * @return String 用户名
     */
    public static String getCurrentUsername() {
        Object principal = getOauth2Authentication().getPrincipal();
        if (principal instanceof HlbAuthUser) {
            return ((HlbAuthUser) principal).getUsername();
        }
        return (String) getOauth2Authentication().getPrincipal();
    }

    private static OAuth2Authentication getOauth2Authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (OAuth2Authentication) authentication;
    }
}
