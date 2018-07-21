package com.inkss.hb.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*", filterName = "CommonFilter") //拦截所有请求
public class CommonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 转换为子接口类型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //设置响应报头允许当前应用被跨域请求（CROS）
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session = request.getSession();

        // 获得用户请求的URL
        String url = request.getRequestURI();
        boolean check = false;
        System.out.println(url);
        // 因为是全局过滤，所以会对所有请求进行过滤，诸如css、js、png等等
        // 所以应该做到只拦截.html和.jsp请求，对请求地址的末尾进行判断
        if (url.endsWith(".jsp") || url.endsWith(".html") || url.endsWith(".do")
                || url.endsWith("win10.js") || url.equals("/hb/MAIN/main.jsp"))
            check = true;

        if (url.endsWith("login.do") )
            check = false;

        if (!url.equals("/hb") && check) {
            // 判断session中此值是否存在
            if (session.getAttribute("loginName") != null) {
                chain.doFilter(request, response); //放行
            } else {
                response.sendRedirect("/hb"); //跳转回根目录
            }
        } else {
            // 非html和jsp请求一律不管
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
