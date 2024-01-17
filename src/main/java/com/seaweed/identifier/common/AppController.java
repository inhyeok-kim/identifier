package com.seaweed.identifier.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/app","/app/*","/app/**"})
public class AppController {

    @GetMapping("")
    public String index(){

        return "index";
    }
}
