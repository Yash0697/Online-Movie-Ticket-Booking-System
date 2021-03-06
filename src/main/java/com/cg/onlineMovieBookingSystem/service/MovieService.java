package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;

@Service
public interface MovieService {

	List<Movie> showAllMovies();

	boolean saveMovie(Movie movie);

	void deleteById(int id);

	Optional<Movie> findByMovieName(String movieName);

}
