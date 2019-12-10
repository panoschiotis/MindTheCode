package com.example.demo.controllers;

import com.example.demo.MainInteractor;
import com.example.demo.model.GenericResponse;
import com.example.demo.model.MainPageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tour-office/") // geniko koino gia olous

public class MainPageController {

    @Autowired
    private MainInteractor interactor;

    @GetMapping("/mainPage/{userStatus}")
    public ResponseEntity getMainPage(@PathVariable String userStatus) {

        GenericResponse<MainPageResponse> response = interactor.getMainPageByUserStatus(userStatus);
        if (response.getError() == null) {
            return new ResponseEntity(
                    response.getData(),
                    null,
                    HttpStatus.OK);
        }
        return new ResponseEntity(
                response.getError(),
                null,
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/mainPage")
    public ResponseEntity getMainPage() {

        GenericResponse<MainPageResponse> response = interactor.getMainPage();

        return new ResponseEntity(
                response.getData(),
                null,
                HttpStatus.OK);
    }


}
