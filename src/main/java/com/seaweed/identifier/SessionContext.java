package com.seaweed.identifier;

import com.seaweed.identifier.login.LoginVO;
import com.seaweed.identifier.user.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionContext {
    public static HttpSession getSession(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }
    public static LoginVO getAuth(){
        return (LoginVO)getSession().getAttribute("auth");
    }

}