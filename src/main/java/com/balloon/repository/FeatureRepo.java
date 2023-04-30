package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balloon.model.Feature;

public interface FeatureRepo extends JpaRepository<Feature, Long> {

}
