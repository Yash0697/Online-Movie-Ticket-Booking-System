package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;

public interface ShowDao {

	List<Seat> showSeatsInShow(int showId);

	void addShow(Show show);

	List<Show> showAllSeats();

	List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId);

	Optional<Show> findByName(String showName);

	Optional<Show> findById(int showId);

	void deleteById(int id);
	
}
