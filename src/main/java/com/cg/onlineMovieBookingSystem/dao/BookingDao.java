package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import com.cg.onlineMovieBookingSystem.Entity.Booking;

public interface BookingDao {

	List<Booking> findAllBookings();

	void saveBooking(Booking booking);

	Optional<Booking> findBuId(int bookingId);

}
