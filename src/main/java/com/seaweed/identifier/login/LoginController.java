package com.seaweed.identifier.login;

import com.seaweed.identifier.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(Model model ,HttpServletRequest request, LoginVO loginVO){
        model.addAttribute("loginVO", loginVO);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model ,HttpServletRequest request){
        loginService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletRequest request
                            , @ModelAttribute("loginVO") LoginVO loginVO){
        String to = request.getParameter("to");
        LoginVO user = loginService.login(loginVO);
        if(user != null && (StringUtils.hasText(user.getId()))){
            if(StringUtils.hasText(to)){
                return "redirect:"+to;
            }
            return "redirect:/";
        }
        model.addAttribute("message","로그인 실패 : 아이디와 비밀번호를 확인하세요.");
        return "login";
    }
}
