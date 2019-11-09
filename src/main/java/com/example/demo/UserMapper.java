package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public List<UserResponse> mapUserResponse(Iterable<User> retrievedUsers) {
        List<UserResponse> users= new ArrayList<>();
        for (User user: retrievedUsers
        ) {
            users.add(new UserResponse(user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getNumberOfBookings(),
                    mapStatusToString(user)
            ));
        }
        return users;
    }

    private String mapStatusToString(User user) {
        return String.valueOf(user.getStatus()).toLowerCase();
    }


}
