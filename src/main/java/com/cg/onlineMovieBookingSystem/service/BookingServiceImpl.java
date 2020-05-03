package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Booking;
import com.cg.onlineMovieBookingSystem.dao.BookingDao;

@Service
public class BookingServiceImpl implements  BookingService{

	@Autowired
	BookingDao bookingDao;
	
	@Override
	public List<Booking> findAllBookings() {
		return bookingDao.findAllBookings();
	}

	@Override
	public void saveBooking(Booking booking) {
		bookingDao.saveBooking(booking);
	}

}
