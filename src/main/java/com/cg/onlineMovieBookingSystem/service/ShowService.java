package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;

@Service
public interface ShowService {

	public List<Seat> showSeatsInShow(int showId);

	public List<Show> showAllSeats();
	
	public void addShow(Show show);

}
