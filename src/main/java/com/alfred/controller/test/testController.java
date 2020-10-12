package com.alfred.controller.test;

import com.alfred.bean.TblUserRecord;
import com.alfred.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class testController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public Boolean test() {
        System.out.println("test");
        return true;
    }

    @PostMapping("/auth/login")
    public Object login(@RequestParam String username, @RequestParam String password) {
        TblUserRecord userRecord = loginService.login(username, password);
        System.out.println(userRecord);
        return JSONObject.parse(JSONObject.toJSONString(userRecord));
    }

}
