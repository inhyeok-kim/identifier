package com.seaweed.identifier.user.controller;

import com.seaweed.identifier.common.APIResponse;
import com.seaweed.identifier.common.ApiController;
import com.seaweed.identifier.user.UserService;
import com.seaweed.identifier.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserApiController extends ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/search")
    public List<UserVO> findUserList(HttpServletRequest req, HttpServletResponse res
                                     , @RequestParam(name="pageNo",defaultValue = "0") int pageNo
                                    , @RequestParam(name="pageSize",defaultValue = "1") int pageSize){
        Pageable pageReq = PageRequest.of(pageNo,pageSize);
        List<UserVO> result = userService.findUsers(pageReq);
        return result;
    }

    @PostMapping("/user/update")
    public APIResponse updateUser(HttpServletRequest req
                        ,HttpServletResponse res
                        ,@RequestBody(required = true) UserVO user){
        APIResponse response = new APIResponse();
        if(user.getSeq() > 0){
            userService.saveUser(user);
            response.setStatus(APIResponse.Status.Ok);
        } else {
            response.setMessage("failed");
            response.setStatus(APIResponse.Status.Failed);
        }
        return response;
    }

    @PostMapping("/user/create")
    public APIResponse createUser(HttpServletRequest req
            ,HttpServletResponse res
            ,@RequestBody(required = true) UserVO user){
        APIResponse response = new APIResponse();
        if(user.getSeq() > 0){
            response.setMessage("failed");
            response.setStatus(APIResponse.Status.Failed);
        } else {
            userService.saveUser(user);
            response.setStatus(APIResponse.Status.Ok);
        }
        return response;
    }
}
