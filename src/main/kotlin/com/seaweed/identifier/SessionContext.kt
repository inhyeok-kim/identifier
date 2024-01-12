package com.seaweed.identifier

import com.seaweed.identifier.user.User
import jakarta.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

class SessionContext {
    companion object{
        fun getSession() : HttpSession {
            return (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request.getSession()
        }
        fun getAuth() : User {
            return getSession().getAttribute("auth") as User
        }

    }
}