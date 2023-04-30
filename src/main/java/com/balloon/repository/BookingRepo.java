package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balloon.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
