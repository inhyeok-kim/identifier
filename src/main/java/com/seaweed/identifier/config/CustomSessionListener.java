package com.seaweed.identifier.config;

import com.seaweed.identifier.login.LoginService;
import com.seaweed.identifier.login.LoginVO;
import com.seaweed.identifier.user.vo.UserVO;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        var session = se.getSession();
        if (session != null) {
            if(session.getAttribute("auth") != null){
                LoginVO user = (LoginVO)session.getAttribute("auth");
                LoginService.loginSessionMap.remove(user.getSeq(),session);
            }
        }
    }
}