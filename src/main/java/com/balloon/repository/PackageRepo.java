package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.model.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, Long>{

}
