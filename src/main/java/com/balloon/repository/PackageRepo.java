package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balloon.model.Package;

public interface PackageRepo extends JpaRepository<Package, Long>{

}
