package com.example.demo.controllers;

import com.example.demo.model.GetAllUsersResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/allUsers")
    public GetAllUsersResponse getAllUsers(){

        return new GetAllUsersResponse(service.getAllUsers());
    }
}
