package com.tastyfoods.search.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepository extends ReactiveCrudRepository<> {
}
