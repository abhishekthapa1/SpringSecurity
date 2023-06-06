package com.springsecurity.controller;


import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PageController {

    @Autowired
    private UserService service;

    @GetMapping
    public String homePage() {
        return "this is home page";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userAccessPage() {
        return "this is user page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminAccessPage()
    {
        return "this is admin page";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("userInfo") UserInfo userInfo)
    {
        return service.addUser(userInfo);
    }

}
