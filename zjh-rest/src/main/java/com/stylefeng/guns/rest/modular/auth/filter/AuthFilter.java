package com.stylefeng.guns.rest.modular.auth.filter;

import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.util.RenderUtil;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:04
 */
public class AuthFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // ----解决跨域访问报错开始----
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
//        response.setContentType("text/html;charset=utf-8");
        // ----解决跨域访问报错结束----

        // -----判断放行条件开始 ----------
        boolean releaseConditon = logicReleaseCondition(request);
        if (releaseConditon) {
            chain.doFilter(request, response);
            return;
        }
        // -----判断放行条件结束 ----------

        // -------判断Tooken合法性开始------------
        log.info("校验token的合法性");
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            authToken = requestHeader.substring(7);
            System.out.println("token的值为: " + authToken);
            // 验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                if (flag) {
                    RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_EXPIRED.getCode(),
                            BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
                    return;
                }
            } catch (JwtException e) {
                // 有异常就是token解析失败
                RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(),
                        BizExceptionEnum.TOKEN_ERROR.getMessage()));
                return;
            }
        } else {
            // header没有带Bearer字段
            RenderUtil.renderJson(response,
                    new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
            return;
        }
        chain.doFilter(request, response);
        // -------判断Tooken合法性结束------------
    }

    /**
     * <p>Description</p>
     * <p>校验uri是否是开放uri</p>
     * ===========================
     *
     * @param request HttpServletRequest
     * @return
     * @author created by jy
     * @date 2019/7/23 16:43
     */
    private boolean logicReleaseCondition(HttpServletRequest request) {
        log.info("判断uri是否是开放uri");
        // 如果请求资源为excludeUrl里的值，不做拦截 直接放行.
        if (Arrays.asList(JwtProperties.excludeUrl).contains(request.getServletPath())) {
            return true;
        }
        return false;
    }
}