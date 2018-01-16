package com.megagao.production.ssm.filter;

import org.apache.shiro.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created on 2017年5月29日 
 *
 * session过滤器，修改response对象，设置session超时标识
 *
 * @author  megagao
 * @version  0.0.1
 */
public class SessionFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,
            ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            //判断session里是否有用户信息,且是否为ajax请求，如果是ajax请求响应头会有，x-requested-with
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                response.setHeader("session-status", "timeout");//在响应头设置session状态
            }
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
