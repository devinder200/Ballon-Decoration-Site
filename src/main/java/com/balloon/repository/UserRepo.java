package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
