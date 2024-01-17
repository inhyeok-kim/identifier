package com.seaweed.identifier.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {
    @GetMapping("/")
    public String index(){
        return "redirect:/app";
    }
}
