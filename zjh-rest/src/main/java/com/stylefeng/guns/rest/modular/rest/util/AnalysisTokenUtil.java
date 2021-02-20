package com.stylefeng.guns.rest.modular.rest.util;

import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/8/18
 */
@Component
public class AnalysisTokenUtil {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * <p>Description</p>
     * <p>从token中解析授权的用户名</p>
     * ===========================
     *
     * @param request HttpServletRequest
     * @return
     * @author created by jy
     * @date 2019/7/24 16:52
     */
    public String getPhoneFormToken(HttpServletRequest request) {
        String account = "";
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            authToken = requestHeader.substring(7);
            account = jwtTokenUtil.getUsernameFromToken(authToken);
            account = account.substring(0, account.length() - 6);
            return account;
        }
        return null;
    }
}
