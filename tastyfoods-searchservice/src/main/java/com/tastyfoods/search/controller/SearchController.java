package com.tastyfoods.search.controller;


import com.tastyfoods.search.model.SearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/location/")
    public SearchResponse searchByLocation(){

            return SearchResponse.builder().build();
    }

    @GetMapping("/distance/")
    public SearchResponse searchByDistance(){

        return SearchResponse.builder().build();
    }

    @GetMapping("/cuisine/")
    public SearchResponse searchByCuisine(){

        return SearchResponse.builder().build();
    }

    @GetMapping("/budget/")
    public SearchResponse searchByBudget(){

        return SearchResponse.builder().build();
    }

    @GetMapping("/name/")
    public SearchResponse searchByName(){
        return SearchResponse.builder().build();
    }

    @GetMapping("/menu/")
    public SearchResponse getMenu(){
        return SearchResponse.builder().build();
    }

}
