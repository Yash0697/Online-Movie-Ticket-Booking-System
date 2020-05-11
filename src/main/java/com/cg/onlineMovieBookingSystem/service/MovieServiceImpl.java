package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.dao.MovieDao;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	@Override
	public List<Movie> showAllMovies() {
		return movieDao.showAllMovies();
	}

	@Override
	public boolean saveMovie(Movie movie) {
		
		Optional<Movie> movieOptional = movieDao.getById(movie.getMovieId());
		if(movieOptional.isPresent()){
			return false;
		}
		else{
		movieDao.saveMovie(movie);
		return true;
		}
		
	}

	@Override
	public void deleteById(int id) {
		movieDao.deleteById(id);
		
	}

}
