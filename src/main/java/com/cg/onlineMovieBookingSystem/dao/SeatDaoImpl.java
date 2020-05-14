package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.repository.SeatRepository;

@Component
public class SeatDaoImpl implements SeatDao{

	@Autowired
	SeatRepository seatRepository;
	@Override
	public Seat getSeat(int seatId) {
		Optional<Seat> seat = seatRepository.findById(seatId);
		if(seat.isPresent())
			return seat.get();
		else
			return null;
	}
	@Override
	public void saveSeat(Seat seat) {
		seatRepository.save(seat);
	}
	
	@Override
	public List<Seat> getAllSeats() {
		return (List<Seat>) seatRepository.findAll();
	}
	@Override
	public void deleteById(int seatId) {
		seatRepository.deleteById(seatId);
		
	}

}
