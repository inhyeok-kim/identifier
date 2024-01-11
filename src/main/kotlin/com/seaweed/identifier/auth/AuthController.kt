package com.seaweed.identifier.auth

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

@Controller
@RequestMapping("/auth")
class AuthController(
    private val authservice: Authservice
) {

    @GetMapping("/login")
    fun index(model : Model, request : HttpServletRequest) : String{
        model.addAttribute("loginInfo",User(id="test"))
        return "login"
    }

    @PostMapping("/login")
    fun login(request : HttpServletRequest, @ModelAttribute("loginInfo") user: User) : String{
        println(user.toString())

        return "redirect:/"
    }
}