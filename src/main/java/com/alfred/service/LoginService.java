package com.alfred.service;

import com.alfred.bean.TblUserRecord;
import com.alfred.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private TblUserRecordMapper userRecordMapper;

    public TblUserRecord login(String username, String password) {
        return userRecordMapper.login(username, password);
    }

}
