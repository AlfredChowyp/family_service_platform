package com.alfred.controller.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @RequestMapping("/auth/login")
    public String test(){
        System.out.println("test");
        return "";
    }
}
