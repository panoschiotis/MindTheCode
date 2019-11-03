package com.example.demo.model;

import java.util.List;

public class GetAllUsersResponse {
    private List<UserResponse> users;

    public GetAllUsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
