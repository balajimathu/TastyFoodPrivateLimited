package com.tastyfoods.search.service;

import com.tastyfoods.search.dao.SearchRepository;
import com.tastyfoods.search.model.MenuItem;
import com.tastyfoods.search.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private static final DecimalFormat distanceFormat = new DecimalFormat("0.00");

    @Autowired
    SearchRepository searchRepository;

    public List<Restaurant> searchByLocation(String city) {

        return searchRepository.findByCity(city);
    }

    public Map<Double, Restaurant> searchByDistance(double latitude, double longitude) {

        List<Restaurant> restaurants = searchRepository.findAll();

        return getRestaurantWithDistance(latitude, longitude, restaurants);
    }

    private Map<Double, Restaurant> getRestaurantWithDistance(double givenLatitude, double givenLongitude, List<Restaurant> restaurants) {

        Map<Double, Restaurant> distanceAndRestaurants = restaurants.stream().
                collect(Collectors.toMap(restaurant -> ((double) Math.round((org.apache.lucene.util.SloppyMath.haversinMeters
                        (givenLatitude, givenLongitude, restaurant.getLatitude(), restaurant.getLongitude())) / 1000.00)), Function.identity()));
        //distanceAndRestaurants.forEach((k, v) -> System.out.println(k + " KMs for " + v.getName() + ", Lat:" + v.getLatitude() + ", Long:" + v.getLongitude()));

        Map result = distanceAndRestaurants.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }

    public List<Restaurant> searchByCuisine(String cuisine) {

        return searchRepository.findByCuisines_name(cuisine);
    }

    public List<Restaurant> searchByBudget(Double budget) {

        return searchRepository.findByBudget(budget);
    }

    public List<Restaurant> searchByName(String name) {
        return searchRepository.findByName(name);
    }

    public Set<MenuItem> getMenu(Long id) {
         Optional<Restaurant> restaurant =  searchRepository.findById(id);
        return restaurant.isPresent() ? restaurant.get().getMenuItems() : null;

    }


}
