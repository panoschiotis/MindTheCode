package com.example.demo.services;

import com.example.demo.TourPackageMapper;
import com.example.demo.model.TourPackage;
import com.example.demo.model.TourPackageResponse;
import com.example.demo.repositories.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourPackageService {
    @Autowired
    private TourPackageMapper mapper;
    @Autowired
    private TourPackageRepository repository;

    public List<TourPackageResponse> getAllTourPackages(){
        Iterable<TourPackage> retrievedTourPackages= repository.findAll();
        List<TourPackageResponse> tourPackageResponses=new ArrayList<>();
        for (TourPackage tourPackage: retrievedTourPackages
             ) {
            tourPackageResponses.add(mapper.mapTourPackageResponseFromTourPackage(tourPackage));
        }
        return tourPackageResponses;
    }


}
