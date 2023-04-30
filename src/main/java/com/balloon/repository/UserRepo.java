package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balloon.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
