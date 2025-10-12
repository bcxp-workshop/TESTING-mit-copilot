package com.example.repository;

import com.example.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for accessing Series entities from the database.
 */
public interface SeriesRepository extends JpaRepository<Series, Long> {
    Series findByName(String name);
}