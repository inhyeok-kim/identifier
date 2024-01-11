package com.seaweed.identifier.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAllUsers() : List<User>{
        return userRepository.findAll();
    }

    fun saveUser(name : String, id : String){
        userRepository.save(User(name=name, id=id))
    }

    fun updateNameById(id:String, name: String){
        userRepository.updateNameById(id,name);
    }
}