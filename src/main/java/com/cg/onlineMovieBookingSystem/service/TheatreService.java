package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;

@Service
public interface TheatreService {

	public Movie searchMovie(int theatreId, String movieName );
	
	public Screen searchScreen(int theatreId, int screenId);
	
	public Theatre selectByTheatre(String theatreName);
	
	public List<Theatre> selectByCityName(String cityName);
	
	public List<Movie> findMoviesInTheatre(int theatreId);

	public List<Screen> findScreensInTheatre(int theatreId);

	public List<Show> findShowsInTheatre(int theatreId, int screenId);

	public Show selectShow(int theatreId, int screenId, int showId);

	public Screen selectScreen(int theatreId, int screenId);

	public List<String> showCities();

	public List<Seat> showSeats(int theatreId, int screenId, int showId);

	public List<Movie> selectMoviesByCityName(String cityName);

	public String addTheatre(Theatre theatre);

	public List<Theatre> selectByMovieName(String movieName);

	public List<Show> selectByMovieAndTheatre(String movieName, String theatreName);
	
}
