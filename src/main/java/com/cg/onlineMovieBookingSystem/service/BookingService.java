package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Booking;

@Service
public interface BookingService {

	List<Booking> findAllBookings();

	void saveBooking(Booking booking);

}
