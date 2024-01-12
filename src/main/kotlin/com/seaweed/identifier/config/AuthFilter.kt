package com.seaweed.identifier.config

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.userdetails.User
import org.springframework.util.PatternMatchUtils



private val logger = KotlinLogging.logger {  }
class AuthFilter : jakarta.servlet.Filter{
    private val whitelist = arrayOf("/auth/login","/public/*")
    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
        var req = p0 as HttpServletRequest
        var res = p1 as HttpServletResponse
        val requestURI: String = req.getRequestURI()
        if(!isWhiteList(requestURI)){
            var session = req.getSession(false)
            if(session == null || session.getAttribute("auth") == null){
                res.sendRedirect("/auth/login")
            }
        }
        if (p2 != null) {
            p2.doFilter(p0,p1)
        }

    }
    private fun isWhiteList(requestURI: String): Boolean {
        return PatternMatchUtils.simpleMatch(whitelist, requestURI)
    }

}