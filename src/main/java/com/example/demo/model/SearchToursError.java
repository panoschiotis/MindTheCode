package com.example.demo.model;

import com.example.demo.SearchTourStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class SearchToursError implements SearchTourStrategy
{
    @Override
    public GenericResponse<List<Tour>> execute(long criteriaId, Iterable<Tour> allTours, CrudRepository repository) {
        return new GenericResponse<>(new Error(0,"Wrong Search Criteria", "searchCriteria should be : tourPackage"));
    }
}
