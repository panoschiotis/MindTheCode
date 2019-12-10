package com.example.demo.tours;


import com.example.demo.TourMapper;
import com.example.demo.model.Tour;
import com.example.demo.model.TourPackage;
import com.example.demo.model.TourResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TourMapperShould {

    private TourMapper mapper;
    private Tour tourInput;
    private TourPackage packageInput;
    private TourResponse output;
    @Before
    public void setup(){

        mapper=new TourMapper();

        tourInput=new Tour(1000, 400, "Da best tour", "shorty", "longy");
        tourInput.setId(100);
        packageInput= new TourPackage("package desc da best", 3000, "Ionio");
        packageInput.setId(200);
        tourInput.setTourPackage(packageInput);
        output= mapper.mapTourResponseFromTour(tourInput);

    }

    @Test
    public void keepSameId(){

        Assert.assertEquals(100, output.getId());
    }

    @Test
    public void keepSamePrice(){
        Assert.assertEquals(1000, output.getPrice());
    }

    @Test
    public void keepSameDiscount(){
        Assert.assertEquals(400, output.getDiscount());
    }

    @Test
    public void calculateFinalPriceByPriceAndDiscount(){
        Assert.assertEquals(600, output.getFinalPrice());
    }

    @Test
    public void keepSameTitle(){
        Assert.assertEquals(tourInput.getTitle(), output.getTitle());
    }

    @Test
    public void keepSameShortDescription(){
        Assert.assertEquals(tourInput.getShortDescription(), output.getShortDescription());
    }

    @Test
    public void keepSameLongDescription(){
        Assert.assertEquals(tourInput.getLongDescription(), output.getLongDescription());
    }

    @Test
    public void setTitleFromTourPackage(){
        Assert.assertEquals(tourInput.getTourPackage().getDesc(), output.getTourPackageTitle());
    }



}
