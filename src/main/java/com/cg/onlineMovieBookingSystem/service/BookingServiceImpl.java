package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

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
	public boolean saveBooking(Booking booking) {
		Optional<Booking> bookingOptional = bookingDao.findBuId(booking.getBookingId());
		if(bookingOptional.isPresent()){
			return false;
		}
		else{
			String userId = Integer.toString(booking.getUserId());
			String theatreId = Integer.toString(booking.getShowRef().getTheatreId());
			String movieId = Integer.toString(booking.getMovieId());
			String showId = Integer.toString(booking.getShowId());
			String id = userId + theatreId + movieId + showId;
			String randomGenerated = Integer.toString((int)((Math.random()*((9999-1000)+1)))+1000);
			int bookingId = Integer.parseInt(randomGenerated + id);
			booking.setBookingId(bookingId);
		bookingDao.saveBooking(booking);
		return true;
		}
	}

}
