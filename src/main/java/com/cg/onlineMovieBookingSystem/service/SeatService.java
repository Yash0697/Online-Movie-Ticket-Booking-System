package com.cg.onlineMovieBookingSystem.service;

import org.springframework.stereotype.Service;

@Service
public interface SeatService {

	public boolean blockSeat(int seatId);
	public boolean bookSeat(int seatId);
	public boolean cancelSeatBooking(int seatId);
}
