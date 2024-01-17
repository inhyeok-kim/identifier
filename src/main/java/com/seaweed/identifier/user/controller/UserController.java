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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public String viewUserList(HttpServletRequest req, HttpServletResponse res
        , Model model){
        model.addAttribute("menu","user");
        Pageable pageReq = PageRequest.of(0,10);
        List<UserVO> result = userService.findUsers(pageReq);
        model.addAttribute("list",result);
        return "user/list";
    }

}
