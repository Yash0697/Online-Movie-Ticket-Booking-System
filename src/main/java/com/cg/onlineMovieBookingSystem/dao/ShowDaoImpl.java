package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.repository.ShowRepository;

@Component
public class ShowDaoImpl implements ShowDao{

	@Autowired
	ShowRepository showRepository;
	@Override
	public List<Seat> showSeatsInShow(int showId) {
		return showRepository.showSeatsInShow(showId);
	}
	@Override
	public void addShow(Show show) {
		showRepository.save(show);		
	}
	@Override
	public List<Show> showAllSeats() {
		return (List<Show>) showRepository.findAll();
	}
	@Override
	public List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId) {
		return showRepository.findShowsByMovieAndTheatre(movieId, theatreId);
	}

}
