package com.seaweed.identifier.auth

import com.seaweed.identifier.SessionContext
import com.seaweed.identifier.user.User
import com.seaweed.identifier.user.UserRepository
import jakarta.servlet.http.HttpSession
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Service
class Authservice(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    companion object {
        val loginSessionMap : HashMap<Long,HttpSession> = HashMap()
    }

    fun login(user : User) : User{
        if(user != null){
            if(!(user.id.isNullOrEmpty()) && !(user.password.isNullOrEmpty())){
                var loginUser : User = userRepository.findOneForLogin(user.id!!, passwordEncoder.encode(user.password))

                if(loginUser != null){
                    return loginProc(loginUser)
                }
            }
        }
        return User()
    }

    private fun loginProc(user : User) : User{
        user.seq?.let {
            loginSessionMap.put(it,SessionContext.getSession())
            return user
        } ?: return User()
    }

}