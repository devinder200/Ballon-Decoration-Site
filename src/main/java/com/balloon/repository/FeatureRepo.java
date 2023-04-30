package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.model.Feature;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Long> {

}
