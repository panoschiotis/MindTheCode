package com.example.demo.services;

import com.example.demo.SearchTourStrategy;
import com.example.demo.TourMapper;
import com.example.demo.model.*;

import com.example.demo.model.Error;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    private TourMapper mapper;

    private TourRepository repository;

    private TourPackageRepository tourPackageRepository;
    @Autowired
    SearchTourFactory factory;

    public TourService(TourMapper mapper, TourRepository repository, TourPackageRepository tourPackageRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.tourPackageRepository = tourPackageRepository;
    }

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
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> toursToReturn = new ArrayList<>();
        SearchTourStrategy strategy = factory.makeStrategyForCriteria(criteria);
        GenericResponse<List<Tour>> tours = strategy.execute(criteriaId, retrievedTours, tourPackageRepository);
        if (tours.getError() == null) {
            for (Tour tour : tours.getData()
            ) {

                toursToReturn.add(mapper.mapTourResponseFromTour(tour));

            }
            return new GenericResponse<List<TourResponse>>(toursToReturn);
        }


        return new GenericResponse<>(tours.getError());
    }
}
