package com.yuexin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEncoding implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    // doFilter·½·¨  
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("urf-8");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}  
