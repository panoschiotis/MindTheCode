package com.example.demo.model;

import java.util.List;

public class MainPageResponse {

    private int numberOfTours;
    private int numberOfUsers;
    private List<TourResponse> tours;
    private List<UserResponse> users;

    public MainPageResponse(int numberOfTours, int numberOfUsers, List<TourResponse> tours, List<UserResponse> users) {
        this.numberOfTours = numberOfTours;
        this.numberOfUsers = numberOfUsers;
        this.tours = tours;
        this.users = users;
    }

    public int getNumberOfTours() {
        return numberOfTours;
    }

    public void setNumberOfTours(int numberOfTours) {
        this.numberOfTours = numberOfTours;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<TourResponse> getTours() {
        return tours;
    }

    public void setTours(List<TourResponse> tours) {
        this.tours = tours;
    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
}
