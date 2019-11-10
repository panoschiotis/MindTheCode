package com.example.demo;

import com.example.demo.model.GenericResponse;
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
    private UserService userService;

    @Autowired
    private TourPackageService tourPackageService;

    public HomePageResponse getHomePage(){
        List<TourPackageResponse> tourPackages=tourPackageService.getAllTourPackages();
        GenericResponse<List<UserResponse>> users=userService.getAllUsers();
        int numberOfTourPackages= tourPackages.size();
        int numberOfUsers = users.getData().size();
        String title="Home Page";
        return new HomePageResponse(title,numberOfTourPackages,numberOfUsers,tourPackages,users.getData());
    }
}
