package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;

@Service
public interface ShowService {

	public List<Seat> showSeatsInShow(int showId);

	public List<Show> showAllSeats();
	
	public boolean addShow(Show show);

	public List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId);

	public Optional<Show> findByName(String showName);

	public Optional<Show> findById(int showId);

	public void deleteById(int id);
	
}
