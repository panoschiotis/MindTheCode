package com.example.demo.controllers;

import com.example.demo.HomeInteractor;
import com.example.demo.model.HomePageResponse;
import com.example.demo.model.TourPackage;
import com.example.demo.model.TourPackageResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // oxi akrivws rest gt den einai restfull alla auto prepei na grapsoume
public class HomePageController {

   @Autowired
    HomeInteractor interactor;

    @GetMapping("/home")
    public HomePageResponse getHomePage(){
        return interactor.getHomePage();
    }

}
