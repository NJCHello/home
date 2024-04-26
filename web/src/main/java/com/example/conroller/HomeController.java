package com.example.conroller;


import com.example.api.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomeController {

    @Resource(name = "peopleServiceImpl")
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return userService.getUserName();
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/hello");
    }
}
