package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;

@Service
public interface SeatService {

	public boolean blockSeat(int seatId);
	public boolean bookSeat(int seatId);
	public boolean cancelSeatBooking(int seatId);
	public void saveSeat(Seat seat);
	public List<Seat> getAllSeats();
}
