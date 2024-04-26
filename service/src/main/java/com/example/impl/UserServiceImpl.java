package com.example.impl;

import com.example.api.UserService;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName() {
        return "chello";
    }
}
