package com.example.demo.controllers;

import com.example.demo.model.*;
import com.example.demo.model.Error;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tour-office/") // geniko koino gia olous

public class TourController {

    @Autowired
    private TourService service;

    @Autowired
    private TourRepository repository;
    @Autowired
    private TourPackageRepository tourPackageRepository;

    @GetMapping("/allTours")
    public ResponseEntity getAllTours(){
         return new ResponseEntity(
                 new GenericResponse( service.getAllTours()).getData(),
                 null,
                 HttpStatus.OK);
    }

    @GetMapping("/getToursByPackageId/{tourPackageId}")
    public ResponseEntity getToursByPackageId(@PathVariable Long tourPackageId){
        try {
            return new ResponseEntity(
                     new GetAllToursResponse(service.getToursByPackageId(tourPackageId)),
                    null,
                    HttpStatus.OK
                    );
        }
        catch(Exception e){
            e.printStackTrace();

            return new ResponseEntity(
                    new Error(0, "Error","Something went wrong, please try again"),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @GetMapping("/allExpensiveTours")
    public ResponseEntity getExpensiveTours(){
        return new ResponseEntity(
                new GenericResponse(service.getExpensiveTours()).getData(),
                null,
                HttpStatus.OK);
    }

    @GetMapping("/getToursByCriteria/{criteria}/{criteriaId}")
    public ResponseEntity getToursByCriteria(@PathVariable String criteria, @PathVariable Long criteriaId)throws NumberFormatException{


        GenericResponse<List<TourResponse>> response= service.getToursByCriteria(criteria,criteriaId);
        if(response.getError()!=null){
            return new ResponseEntity(
                    response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity(
                new GetAllToursResponse(response.getData()),
                null,
                HttpStatus.OK);
    }

    @PostMapping("/createTour")
    public Tour createTour(@RequestBody Tour tour){
       // TourPackage tourPackage= tourPackageRepository.findById(tour.getTourPackage().getId()).get();
       // tour.setTourPackage(tourPackage);
        repository.save(tour);
        return tour;
    }

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity handleException(){
        return new ResponseEntity(new Error(0,"Wrong second input type","Must be Long"),
                null,
                HttpStatus.BAD_REQUEST);

    }

}
