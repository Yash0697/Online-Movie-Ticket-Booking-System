package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;

@Service
public interface TheatreService {

	public Movie searchMovie(String movieName );
	
	public Screen searchScreen(int theatreId, int screenId);
	
	public Theatre selectByTheatre(String theatreName);
	
	public List<Theatre> selectByCityName(String cityName);
	
	public List<Movie> findMoviesInTheatre(int theatreId);

	public List<Screen> findScreensInTheatre(int theatreId);
}
