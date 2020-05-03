package com.cg.onlineMovieBookingSystem.service;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;

@Service
public interface TheatreService {

	public Movie searchMovie(String movieName );
	
	public Screen searchScreen(int theatreId, int screenId);
}
