package com.example.demo.model;

import java.util.List;

public class GetAllTourPackagesResponse {
    private List<TourPackageResponse> tourPackageResponses;

    public GetAllTourPackagesResponse(List<TourPackageResponse> tourPackageResponses) {
        this.tourPackageResponses = tourPackageResponses;
    }

    public List<TourPackageResponse> getTourPackageResponses() {
        return tourPackageResponses;
    }

    public void setTourPackageResponses(List<TourPackageResponse> tourPackageResponses) {
        this.tourPackageResponses = tourPackageResponses;
    }
}
