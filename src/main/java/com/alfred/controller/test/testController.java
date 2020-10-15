package com.alfred.controller.test;

import com.alfred.bean.TblUserRecord;
import com.alfred.returnObject.Permission;
import com.alfred.returnObject.Permissions;
import com.alfred.returnObject.ReturnObject;
import com.alfred.returnObject.UserInfo;
import com.alfred.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
    public JSONObject login(@RequestParam String username, @RequestParam String password) {
        TblUserRecord userRecord = loginService.login(username, password);
        userRecord.setToken(userRecord.getUserName());
        //将用户数据写入到session
//        session.setAttribute("userRecord", userRecord);
        ReturnObject ro = new ReturnObject(userRecord);
        return JSONObject.parseObject(JSONObject.toJSONString(ro));
    }

    @RequestMapping("/user/info")
    public JSONObject getInfo(HttpSession session) {
        //获取用户数据
        TblUserRecord userRecord = (TblUserRecord) session.getAttribute("userRecord");
        //获取对应用户需要账务的功能模块
        String[] rolePrivileges = userRecord.getTblRole().getRolePrivileges().split("-");
        // 拼接需要返回的数据对象的格式
        Permissions permissions = new Permissions();
        List<Permission> permissionList = new ArrayList<>();
        for (String rolePrivilege : rolePrivileges) {
            permissionList.add(new Permission(rolePrivilege));
        }
        permissions.setPermissions(permissionList);
        UserInfo userInfo = new UserInfo(userRecord.getUserName(), permissions);
        ReturnObject ro = new ReturnObject(userInfo);
        return JSONObject.parseObject(JSONObject.toJSONString(ro));
    }


}
