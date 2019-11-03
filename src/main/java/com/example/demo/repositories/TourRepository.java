package com.example.demo.repositories;

import com.example.demo.model.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface TourRepository extends CrudRepository<Tour, Long> {

}
