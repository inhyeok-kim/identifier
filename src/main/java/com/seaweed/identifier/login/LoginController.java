package com.seaweed.identifier.login;

import com.seaweed.identifier.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String index(Model model ,HttpServletRequest request, UserVO loginVO){
        model.addAttribute("loginVO", loginVO);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request, @ModelAttribute("loginVO") LoginVO loginVO){
        LoginVO user = loginService.login(loginVO);
        if(user != null && (StringUtils.hasText(user.getId()))){
            return "redirect:/";
        }
        model.addAttribute("message","로그인 실패 : 아이디와 비밀번호를 확인하세요.");
        return "login";
    }
}
