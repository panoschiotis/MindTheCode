package com.example.demo.services;

import com.example.demo.Status;
import com.example.demo.UserMapper;
import com.example.demo.model.Error;
import com.example.demo.model.GenericResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.repositories.UserRepository;
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

    public GenericResponse<List<UserResponse>> getAllUsers(){
        return new GenericResponse<>(mapper.mapUserResponse(repository.findAll()));
    }


    public GenericResponse<List<UserResponse>> getUserByStatus(String userStatus) {
        GenericResponse<List<UserResponse>> mappedUsers=getAllUsers();
        List<UserResponse> usersByStatus=new ArrayList<>();
        for (Status status : Status.values()
             ) {
            if(userStatus.equalsIgnoreCase(status.toString())){

                for (UserResponse user: mappedUsers.getData()
                ) {
                    if(user.getStatus().equalsIgnoreCase(userStatus)){
                        usersByStatus.add(user);
                    }
                }
                return new GenericResponse<>(usersByStatus);
            }
        }
        return new GenericResponse<>(new Error(0, "Wrong Input", "User Status are new, loyal , gold, platinum"));

    }
}
