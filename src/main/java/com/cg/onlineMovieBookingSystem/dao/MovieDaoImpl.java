package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void deleteById(int id) {
		movieRepository.deleteById(id);
		
	}

	@Override
	public Optional<Movie> getById(int movieId) {
		return movieRepository.findById(movieId);
	}

	@Override
	public Optional<Movie> findByMovieName(String movieName) {
		return movieRepository.findByMovieName(movieName);
	}
	
	
}
