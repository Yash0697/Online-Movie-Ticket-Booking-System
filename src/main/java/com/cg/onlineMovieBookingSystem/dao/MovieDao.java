package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import com.cg.onlineMovieBookingSystem.Entity.Movie;

public interface MovieDao {

	List<Movie> showAllMovies();

	void saveMovie(Movie movie);

	void deleteById(int id);

	Optional<Movie> getById(int movieId);

	Optional<Movie> findByMovieName(String movieName);

}
