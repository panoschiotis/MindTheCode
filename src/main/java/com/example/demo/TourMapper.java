package com.example.demo;

import com.example.demo.model.Tour;
import com.example.demo.model.TourResponse;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {

    public TourResponse mapTourResponseFromTour(Tour tour) {
        return new TourResponse(
                tour.getId(),
                tour.getPrice(),
                tour.getDiscount(),
                mapFinalPrice(tour),
                tour.getTitle(),
                tour.getShortDescription(),
                tour.getLongDescription(),
                mapTitleFromTourPackage(tour));
    }

    private String mapTitleFromTourPackage(Tour tour) {
        if(tour.getTourPackage()!=null){
            return tour.getTourPackage().getDesc();
        }
        else
            return "";

    }

    private int mapFinalPrice(Tour tour) {
        return tour.getPrice()-tour.getDiscount();
    }


}


