package com.example.demo.model;

import com.example.demo.SearchTourStrategy;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchToursByTourPackage implements SearchTourStrategy {
    @Override
    public GenericResponse<List<Tour>> execute(long criteriaId, Iterable<Tour> allTours, CrudRepository repository) {
        List<Tour> tours= new ArrayList<>();
        if(!repository.findById(criteriaId).isPresent()){
            return new GenericResponse(new Error(0, "Wrong input", "tourpackage with id : " + criteriaId + " does not exist"));

        }
        for (Tour tour : allTours
        ) {
            if (tour.getTourPackage()!=null &&tour.getTourPackage().getId() == criteriaId) {
                tours.add(tour);
            }
        }
        return new GenericResponse<List<Tour>>(tours);


    }
}
