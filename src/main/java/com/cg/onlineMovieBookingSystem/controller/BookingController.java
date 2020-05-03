package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Booking;
import com.cg.onlineMovieBookingSystem.service.BookingService;

@RestController
@CrossOrigin(value="http;//localhost:4200")
@RequestMapping(value="/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping("/all")
	public List<Booking> showAllBookings(){
		return bookingService.findAllBookings();
	}
	
	@PostMapping("/addBooking")
	public void addBooking(@RequestBody Booking booking){
		bookingService.saveBooking(booking);
	}
}
