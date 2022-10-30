package com.tastyfoods.search.dao;

import com.tastyfoods.search.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAll();

    List<Restaurant> findAll(Sort sort);

    List<Restaurant> findByCity(String location);

    List<Restaurant> findByCuisines_name(String cuisine);

    List<Restaurant> findByBudget(Double budget);

    List<Restaurant> findByName(String name);
}
