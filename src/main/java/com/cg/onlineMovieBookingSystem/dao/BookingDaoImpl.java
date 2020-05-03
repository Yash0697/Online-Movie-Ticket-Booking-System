package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Booking;
import com.cg.onlineMovieBookingSystem.repository.BookingRepository;

@Component 
public class BookingDaoImpl implements BookingDao {

	@Autowired
	BookingRepository bookingRepository;
	@Override
	public List<Booking> findAllBookings() {
		return (List<Booking>) bookingRepository.findAll();
	}
	@Override
	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
	}

}
