package com.seaweed.identifier.user;

import com.seaweed.identifier.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    public List<UserVO> findUsers(Pageable pageable){
        return userRepository.findAll(pageable).getContent();
    }

    public long countUsers(){
        return userRepository.count();
    }

    public void saveUser(UserVO user){
        userRepository.save(user);
    }

    public void updateNameById(String id, String name){
        userRepository.updateNameById(id,name);
    }
}