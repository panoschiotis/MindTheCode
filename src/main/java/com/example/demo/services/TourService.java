package com.example.demo.services;

import com.example.demo.TourMapper;
import com.example.demo.model.Tour;
import com.example.demo.model.TourResponse;
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

    public List<TourResponse> getAllTours() {

        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList();
        for (Tour tour : retrievedTours) {
            tours.add(mapper.mapTourResponseFromTour(tour));

        }
        return tours;
    }


    public List<TourResponse> getToursByPackageId(Long tourPackageId) {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrievedTours) {
            if (tour.getTourPackage().getId() == tourPackageId) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }

        }
        return tours;
    }

    public List<TourResponse> getExpensiveTours() {
        List<TourResponse> allTourResponses = getAllTours();
        List<TourResponse> tours = new ArrayList<>();
        for (TourResponse tour : allTourResponses
        ) {
            if (tour.getFinalPrice() > 500) {
                tours.add(tour);
            }


        }
        return tours;
    }
}
