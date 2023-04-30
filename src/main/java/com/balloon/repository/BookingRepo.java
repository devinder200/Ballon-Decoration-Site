package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}
