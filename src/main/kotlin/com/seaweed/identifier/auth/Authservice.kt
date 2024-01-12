package com.seaweed.identifier.auth

import com.seaweed.identifier.SessionContext
import com.seaweed.identifier.user.User
import com.seaweed.identifier.user.UserRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

private val logger = KotlinLogging.logger {  }
@Service
class Authservice(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    companion object {
        val loginSessionMap : LoginSessionMap = LoginSessionMap()
    }

    fun login(loginVO: LoginVO ) : User{
        if(loginVO != null){
            if(!(loginVO.id.isNullOrEmpty()) && !(loginVO.password.isNullOrEmpty())){
                var loginUser : User = userRepository.findOneByUserId(loginVO.id!!)

                if(loginUser != null){
                    val match = passwordEncoder.matches(loginVO.password,loginUser.password)
                    if(match){
                        return loginProc(loginUser)
                    }
                }
            }
        }
        return User()
    }

    private fun loginProc(user : User) : User{
        user.seq?.let {
            loginSessionMap.add(it,SessionContext.getSession())
            SessionContext.getSession().setAttribute("auth", user)
            return user
        } ?: return User()
    }

}