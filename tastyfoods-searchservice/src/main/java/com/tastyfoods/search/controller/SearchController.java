package com.tastyfoods.search.controller;


import com.tastyfoods.search.model.MenuItem;
import com.tastyfoods.search.model.Restaurant;
import com.tastyfoods.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/location/{city}")
    public List<Restaurant> searchByLocation(@PathVariable String city) {

        List<Restaurant> list = searchService.searchByLocation(city);

        return list;
    }

    @GetMapping("/distance/{latitude}/{longitude}")
    public Map<Double, Restaurant> searchByDistance(@PathVariable double latitude, @PathVariable double longitude) {

        Map<Double, Restaurant> resultByDistance = searchService.searchByDistance(latitude, longitude);

        return resultByDistance;
    }

    @GetMapping("/cuisine/{cuisine}")
    public List<Restaurant> searchByCuisine(@PathVariable String cuisine) {

        List<Restaurant> list = searchService.searchByCuisine(cuisine);
        return list;
    }

    @GetMapping("/budget/{budget}")
    public List<Restaurant> searchByBudget(@PathVariable Double budget) {

        return searchService.searchByBudget(budget);
    }

    @GetMapping("/name/{name}")
    public List<Restaurant> searchByName(@PathVariable String name) {

        List<Restaurant> list = searchService.searchByName(name);
        return list;
    }

    @GetMapping("/menu/{restautantId}")
    public Set<MenuItem> getMenu(@PathVariable Long restautantId) {

        return searchService.getMenu(restautantId);
    }

}
