package com.cg.onlineMovieBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.dao.SeatDao;
import com.cg.onlineMovieBookingSystem.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	SeatRepository seatRepository;
	@Override
	public boolean blockSeat(int seatId) {
		Seat seat = seatDao.getSeat(seatId);
		if(seat != null){
			seat.blockSeat();
			seatRepository.deleteById(seatId);
			seatRepository.save(seat);
			return true;
		}
		return false;
	}
	@Override
	public boolean bookSeat(int seatId) {
		Seat seat = seatDao.getSeat(seatId);
		if(seat != null){
			seat.bookSeat();
			seatRepository.deleteById(seatId);
			seatRepository.save(seat);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean cancelSeatBooking(int seatId) {
		Seat seat = seatDao.getSeat(seatId);
		if(seat != null){
			seat.cancelSeatBooking();
			seatRepository.deleteById(seatId);
			seatRepository.save(seat);
			return true;
		}
		return false;
	}

}
