package com.example.SpringSecurityByJWT;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String homePage(HttpServletRequest request){
        return "Welcome to Home Page" + request.getSession().getId();
    }
}
