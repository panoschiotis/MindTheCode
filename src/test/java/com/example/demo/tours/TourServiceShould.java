package com.example.demo.tours;

import com.example.demo.TourMapper;
import com.example.demo.model.MainPageResponse;
import com.example.demo.model.Tour;
import com.example.demo.model.TourPackage;
import com.example.demo.model.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.services.TourService;
import com.sun.org.apache.xpath.internal.Arg;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hibernate.annotations.Any;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TourServiceShould {

    private TourService service;

    @Mock
    private TourRepository tourRepository;
    @Mock
    private TourPackageRepository tourPackageRepository;
    @Mock
    private TourMapper mapper;

    private Iterable<Tour> mockedTours= new ArrayList<Tour>(){
        {
            add(new Tour(1,1000, 400, "Da best tour", "shorty", "longy", new TourPackage("package desc da best", 3000, "Ionio")));
            add(new Tour(2,1000, 400, "Da best tour", "shorty", "longy", new TourPackage("package desc da best", 3000, "Ionio")));

        }
    };

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(tourRepository.findAll()).thenReturn(mockedTours);
        when(mapper.mapTourResponseFromTour(ArgumentMatchers.any())).thenReturn(tourResponseFromMapper());
        service = new TourService(mapper, tourRepository, tourPackageRepository);

    }

    private TourResponse tourResponseFromMapper() {
        return new TourResponse(1,1000,400, 600,"title","short","long","tp title");
    }

    @Test
    public void retrieveToursFromRepository() {
        service.getAllTours();
        Mockito.verify(tourRepository).findAll(); //check an ontws kalesthke h find all tou repo apo thn getalltours
    }

    @Test
    public void usesTourMapper(){
        service.getAllTours();
        Mockito.verify(mapper,times(2)).mapTourResponseFromTour(ArgumentMatchers.any());

    }
    @Test
    public void returnsListOfTourResponse(){
        List<TourResponse> output =service.getAllTours().getData();
        Assert.assertEquals(2, output.size());
        List<TourResponse> expectedList= new ArrayList<>();
        expectedList.add(tourResponseFromMapper());
        expectedList.add(tourResponseFromMapper());
        Assert.assertThat(expectedList, Matchers.samePropertyValuesAs(output));
       // Assert.assertThat(output, CoreMatchers.hasItems(tourResponseFromMapper(),tourResponseFromMapper()));
    }


}
