package com.example.demo;

import com.example.demo.model.GenericResponse;
import com.example.demo.model.Tour;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchTourStrategy {
    public GenericResponse<List<Tour>> execute(long criteriaId, Iterable<Tour> allTours, CrudRepository repository);
}
