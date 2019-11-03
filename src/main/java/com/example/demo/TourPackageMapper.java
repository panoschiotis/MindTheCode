package com.example.demo;

import com.example.demo.model.TourPackage;
import com.example.demo.model.TourPackageResponse;
import org.springframework.stereotype.Component;

@Component
public class TourPackageMapper {
    public TourPackageResponse mapTourPackageResponseFromTourPackage(TourPackage tourPackage) {
        return new TourPackageResponse(
                tourPackage.getId(),
                mapTitle(tourPackage),
                tourPackage.getPrice()
        );

    }

    private String mapTitle(TourPackage tourPackage) {
        return tourPackage.getDest()+" : "+tourPackage.getDesc();
    }
}
