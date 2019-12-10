package com.example.demo.controllers;

import com.example.demo.model.GenericResponse;
import com.example.demo.model.GetAllUsersResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("tour-office/") // geniko koino gia olous

public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/allUsers")
    public ResponseEntity getAllUsers(){

        return new ResponseEntity(
                service.getAllUsers().getData(),
                null,
                HttpStatus.OK);

    }

    @GetMapping("/usersByStatus/{userStatus}")
    public ResponseEntity getUsersByStatus(@PathVariable String userStatus) {
        GenericResponse<List<UserResponse>> response = service.getUserByStatus(userStatus);
        if (response.getError() == null) {
            return new ResponseEntity(
                    response.getData(),
                    null,
                    HttpStatus.OK);

        }
        return new ResponseEntity(
                response.getError(),
                null,
                HttpStatus.BAD_REQUEST
        );
    }
}
