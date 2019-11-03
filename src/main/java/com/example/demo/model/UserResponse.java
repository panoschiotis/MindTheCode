package com.example.demo.model;

import com.example.demo.Status;
import org.springframework.stereotype.Component;

public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int numberOfBookings;
    private String status;



    public UserResponse(Long id, String firstName, String lastName, int numberOfBookings, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfBookings = numberOfBookings;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
