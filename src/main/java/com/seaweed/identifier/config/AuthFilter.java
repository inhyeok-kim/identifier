package com.seaweed.identifier.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

public class AuthFilter implements Filter {
    private String[] whitelist = {"/login","/public/*","/api/*"};
    @Override
    public void doFilter(ServletRequest p0, ServletResponse p1, FilterChain p2) throws IOException, ServletException {
        var req = (HttpServletRequest)p0;
        var res = (HttpServletResponse)p1;
        String requestURI = req.getRequestURI();
        if(!isWhiteList(requestURI)){
            var session = req.getSession(false);
            if(session == null || session.getAttribute("auth") == null){
                if(StringUtils.hasText(req.getRequestURI()) && !req.getRequestURI().equals("/")){
                    res.sendRedirect("/login?to="+req.getRequestURI());
                } else {
                    res.sendRedirect("/login");
                }

            }
        }
        if (p2 != null) {
            p2.doFilter(p0,p1);
        }

    }
    private Boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }

}