package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import com.cg.onlineMovieBookingSystem.Entity.Movie;

public interface MovieDao {

	List<Movie> showAllMovies();

	void saveMovie(Movie movie);

}
