package com.example.demo.services;

import com.example.demo.TourMapper;
import com.example.demo.model.GenericResponse;
import com.example.demo.model.GetAllToursResponse;
import com.example.demo.model.Tour;
import com.example.demo.model.Error;

import com.example.demo.model.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    private TourMapper mapper = new TourMapper();

    @Autowired
    private TourRepository repository;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public GenericResponse<List<TourResponse>> getAllTours() {

        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList();
        for (Tour tour : retrievedTours) {
            tours.add(mapper.mapTourResponseFromTour(tour));

        }
        return new GenericResponse<>(tours);
    }


    public List<TourResponse> getToursByPackageId(Long tourPackageId) {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrievedTours) {
            if (tour.getTourPackage() != null && tour.getTourPackage().getId() == tourPackageId) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }

        }
        return tours;
    }

    public GenericResponse<List<TourResponse>> getExpensiveTours() {
        GenericResponse<List<TourResponse>> allTourResponses = getAllTours();
        List<TourResponse> tours = new ArrayList<>();
        for (TourResponse tour : allTourResponses.getData()
        ) {
            if (tour.getFinalPrice() > 500) {
                tours.add(tour);
            }


        }
        return new GenericResponse<>(tours);
    }

    //spaei to open/closed ara prepei na ginei refactor se strategy design bu
    public GenericResponse<List<TourResponse>> getToursByCriteria(String criteria, Long criteriaId) {
        Iterable<Tour> tours = repository.findAll();
        List<TourResponse> toursToReturn = new ArrayList<>();
        if (criteria.equalsIgnoreCase("tourPackage")) {
            if (!tourPackageRepository.findById(criteriaId).isPresent()) {
                return new GenericResponse<>(new Error(0, "Wrong input", "tourpackage with id : " + criteriaId + " does not exist"));
            }
            for (Tour tour : tours
            ) {
                if (tour.getTourPackage().getId() == criteriaId) {
                    toursToReturn.add(mapper.mapTourResponseFromTour(tour));
                }
            }
        }

        return new GenericResponse<>(toursToReturn);
    }
}
