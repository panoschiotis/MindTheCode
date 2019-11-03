package com.example.demo.controllers;

import com.example.demo.model.GetAllTourPackagesResponse;
import com.example.demo.services.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourPackageController {
    @Autowired
    private TourPackageService service;

    @GetMapping("/allTourPackages")
    public GetAllTourPackagesResponse getAllTourPackages(){
        return new GetAllTourPackagesResponse(service.getAllTourPackages());

    }
}
