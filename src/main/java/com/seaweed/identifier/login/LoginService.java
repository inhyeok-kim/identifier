package com.seaweed.identifier.login;

import com.seaweed.identifier.common.SessionContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginRepository loginRepository;
    public static LoginSessionMap loginSessionMap = new LoginSessionMap();

    public LoginVO login(LoginVO loginVO ){
        if(loginVO != null){
            if(StringUtils.hasText(loginVO.getId()) && StringUtils.hasText(loginVO.getPassword())){
                LoginVO loginUser = loginRepository.findOneByUserId(loginVO.getId());

                if(loginUser != null){
                    boolean match = passwordEncoder.matches(loginVO.getPassword(),loginUser.getPassword());
                    if(match){
                        return loginProc(loginUser);
                    }
                }
            }
        }
        return new LoginVO();
    }

    public void logout(){
        HttpSession session = SessionContext.getSession();
        LoginVO loginVO = SessionContext.getAuth();
        session.invalidate();
        loginSessionMap.remove(loginVO.getSeq(), session);
    }

    private LoginVO loginProc(LoginVO user){
        if(user.getSeq() >= 0){
            loginSessionMap.add(user.getSeq(),SessionContext.getSession());
            SessionContext.getSession().setAttribute("auth", user);
            return user;
        }
        return new LoginVO();
    }

}