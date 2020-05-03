package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;

@Component
public class MovieDaoImpl implements MovieDao{

	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<Movie> showAllMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
		
	}
	
	
}
