package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;


import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;

public interface ShowDao {

	List<Seat> showSeatsInShow(int showId);

	void addShow(Show show);

	List<Show> showAllSeats();

	List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId);
	
}
