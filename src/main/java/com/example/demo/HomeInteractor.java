package com.example.demo;

import com.example.demo.model.HomePageResponse;
import com.example.demo.model.TourPackageResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeInteractor {

    @Autowired
    UserService userService;

    @Autowired
    TourPackageService tourPackageService;

    public HomePageResponse getHomePage(){
        List<TourPackageResponse> tourPackages=tourPackageService.getAllTourPackages();
        List<UserResponse> users=userService.getAllUsers();
        int numberOfTourPackages= tourPackages.size();
        int numberOfUsers = users.size();
        String title="Home Page";
        return new HomePageResponse(title,numberOfTourPackages,numberOfUsers,tourPackages,users);
    }
}
