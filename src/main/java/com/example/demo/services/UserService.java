package com.example.demo.services;

import com.example.demo.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    public List<UserResponse> getAllUsers(){
        return mapper.mapUserResponse(repository.findAll());
    }


}
