package com.seaweed.identifier.auth

import com.seaweed.identifier.SessionContext
import com.seaweed.identifier.user.User
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import org.springframework.session.Session
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/auth")
class AuthController(
    private val authservice: Authservice
) {

    @GetMapping("/login")
    fun index(model : Model, request : HttpServletRequest, loginVO: LoginVO) : String{
        model.addAttribute("loginVO", loginVO)
        return "login"
    }

    @PostMapping("/login")
    fun login(model: Model, request : HttpServletRequest, @ModelAttribute("loginVO") loginVO: LoginVO) : String{
        var user : User = authservice.login(loginVO)
        user.id?.let{
            return "redirect:/"
        }
        model.addAttribute("message","로그인 실패 : 아이디와 비밀번호를 확인하세요.")
        return "login"
    }
}

data class LoginVO(
    var id : String?,
    var password : String?
)