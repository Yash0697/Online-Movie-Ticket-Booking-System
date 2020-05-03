package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.repository.TheatreRepository;

@Component
public class TheatreDaoImpl implements TheatreDao {

	@Autowired
	TheatreRepository theatreRepository;

	@Override
	public List<Movie> findMovieByName(Movie movie) {
		return theatreRepository.findByListOfMovies1(movie.getMovieName());
	}

	@Override
	public Screen searchScreen(int theatreId, int screenId) {
		System.out.println("searchScreenDao--------------------------------------------------------------------------------------------");
		return theatreRepository.findByListOfScreens1(theatreId, screenId);
	}
	

}
