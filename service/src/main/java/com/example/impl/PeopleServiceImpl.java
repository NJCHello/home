package com.example.impl;

import com.example.api.UserService;
import org.springframework.stereotype.Service;

@Service("peopleServiceImpl")
public class PeopleServiceImpl implements UserService {
    @Override
    public String getUserName() {
        return "null";
    }
}
