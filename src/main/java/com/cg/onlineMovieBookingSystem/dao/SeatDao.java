package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import com.cg.onlineMovieBookingSystem.Entity.Seat;

public interface SeatDao {

	public Seat getSeat(int seatId);

	public void saveSeat(Seat seat);
	
	public List<Seat> getAllSeats();

	public void deleteById(int seatId);
}
