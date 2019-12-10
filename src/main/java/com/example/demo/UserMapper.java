package com.example.demo;

import com.example.demo.model.Users;
import com.example.demo.model.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public List<UserResponse> mapUserResponse(Iterable<Users> retrievedUsers) {
        List<UserResponse> users= new ArrayList<>();
        for (Users user: retrievedUsers
        ) {
            users.add(mapUserToUserResponse(user));
        }
        return users;
    }

    public UserResponse mapUserToUserResponse(Users user) {
        return new UserResponse(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getNumberOfBookings(),
                mapStatusToString(user)
        );
    }

    private String mapStatusToString(Users user) {
        return String.valueOf(user.getStatus()).toLowerCase();
    }


}
