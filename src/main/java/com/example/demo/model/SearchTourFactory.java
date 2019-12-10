package com.example.demo.model;

import com.example.demo.SearchTourStrategy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class SearchTourFactory {
    public SearchTourStrategy makeStrategyForCriteria (String criteria) {
        switch (criteria.toLowerCase()) {
            case "tourpackage":
                return new SearchToursByTourPackage();

            default:
                return new SearchToursError();
        }

    }
}
