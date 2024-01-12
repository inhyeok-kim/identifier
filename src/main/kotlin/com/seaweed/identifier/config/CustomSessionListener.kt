package com.seaweed.identifier.config

import com.seaweed.identifier.auth.Authservice
import com.seaweed.identifier.user.User
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpSession
import jakarta.servlet.http.HttpSessionEvent
import jakarta.servlet.http.HttpSessionListener
import org.springframework.context.annotation.Configuration


private val logger = KotlinLogging.logger {  }
@Configuration
class CustomSessionListener : HttpSessionListener{
    override fun sessionCreated(se: HttpSessionEvent?) {
    }

    override fun sessionDestroyed(se: HttpSessionEvent?) {
        var session = se?.session;
        if (session != null) {
            if(session.getAttribute("auth") != null){
                var user = session.getAttribute("auth") as User
                user.seq?.let { Authservice.loginSessionMap.remove(it,session) }
            }
        }
    }
}