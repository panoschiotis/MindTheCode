package com.example.demo;

import com.example.demo.model.Error;
import com.example.demo.model.GenericResponse;
import com.example.demo.model.MainPageResponse;
import com.example.demo.model.TourResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.services.TourService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainInteractor {

    @Autowired
    private TourService tourService;

    @Autowired
    private UserService userService;

    public GenericResponse<MainPageResponse> getMainPageByUserStatus(String userStatus) {

        GenericResponse<List<TourResponse>> tours = tourService.getAllTours();
        GenericResponse<List<UserResponse>> users = userService.getUserByStatus(userStatus);
        if(users.getError()==null) {
            int numberOfTours = tours.getData().size();
            int numberOfUsers = users.getData().size();
            return new GenericResponse<MainPageResponse>(new MainPageResponse(numberOfTours, numberOfUsers, tours.getData(), users.getData()));
        }

        return new GenericResponse<>(new

    Error(0,"Wrong Input","User status are new, loyal, gold, platinum"));

}

    public GenericResponse<MainPageResponse> getMainPage() {
        GenericResponse<List<TourResponse>> tours = tourService.getAllTours();
        GenericResponse<List<UserResponse>> users = userService.getAllUsers();
        int numberOfTours = tours.getData().size();
        int numberOfUsers = users.getData().size();
        return new GenericResponse<MainPageResponse>(new MainPageResponse(numberOfTours, numberOfUsers, tours.getData(), users.getData()));

    }
}
