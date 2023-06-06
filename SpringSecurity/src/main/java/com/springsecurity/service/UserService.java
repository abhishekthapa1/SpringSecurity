package com.springsecurity.service;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system";
    }

}
