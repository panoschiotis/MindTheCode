package com.example.demo.controllers;

import com.example.demo.model.GenericResponse;
import com.example.demo.model.GetAllToursResponse;
import com.example.demo.model.TourResponse;
import com.example.demo.model.Error;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    private TourService service;

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
    public ResponseEntity getToursByCriteria(@PathVariable String criteria, @PathVariable Long criteriaId){
        if(!criteria.equalsIgnoreCase("tourPackage")){
            return new ResponseEntity(
                    new Error(0,"Wrong Criteria", "The criteria input should be tourPackage"),
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }

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
}
