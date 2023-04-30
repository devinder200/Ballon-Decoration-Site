package com.balloon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.Enums.BookingStatus;
import com.balloon.Exception.ResourceNotFoundException;
import com.balloon.model.Booking;
import com.balloon.repository.BookingRepo;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingRepo bookingRepository;

	// get all bookings
	@GetMapping("/bookings")
	public List<Booking> getBookings() {
		return bookingRepository.findAll();

	}
	
	
	// Add Booking
		@PostMapping("/bookings")
		public Booking addBooking(@RequestBody Booking booking) {
			 return bookingRepository.save(booking);

		}
		
	// get Booking by id
		@GetMapping("/bookings/{id}")
		public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
			 Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No booking found for id: "+ id));
			 return ResponseEntity.ok(booking);
		}
		
	// update Booking details
		@PutMapping("/bookings/{id}")
		public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
			 Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No booking found for id: "+ id));
			 booking.setBookingDate(bookingDetails.getBookingDate());
			 booking.setTimeSlot(bookingDetails.getTimeSlot());
			 booking.setOccasion(bookingDetails.getOccasion());
			 booking.setPincode(booking.getPincode());
			 booking.setVenue(bookingDetails.getVenue());
			 booking.setPackageType(bookingDetails.getPackageType());
			 booking.setUser(bookingDetails.getUser());
			 booking.setBookingStatus(BookingStatus.BOOKED);
			 
			 bookingRepository.save(booking);
			 return ResponseEntity.ok(booking);
		}
		
	// delete Booking details
		@DeleteMapping("bookings/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteBooking(@PathVariable Long id){
			 Booking booking = bookingRepository.findById(id)
					 .orElseThrow(() -> new ResourceNotFoundException("No booking found for id: "+ id));
			 bookingRepository.delete(booking);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return ResponseEntity.ok(response);
		}
}
