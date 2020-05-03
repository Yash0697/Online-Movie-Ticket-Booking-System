package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;
import com.cg.onlineMovieBookingSystem.repository.TheatreRepository;

@Component
public class TheatreDaoImpl implements TheatreDao {

	@Autowired
	TheatreRepository theatreRepository;

	@Override
	public List<Movie> findMovieByName(int theatreId, Movie movie) {
		return theatreRepository.findByListOfMovies1(theatreId, movie.getMovieName());
	}

	@Override
	public Screen searchScreen(int theatreId, int screenId) {
		return theatreRepository.findByListOfScreens1(theatreId, screenId);
	}

	@Override
	public List<Theatre> selectByCity(String cityName) {
		return theatreRepository.findAllByTheatreCity(cityName);
	}

	@Override
	public Optional<Theatre> selectByTheatreName(String theatreName) {
		return theatreRepository.findByTheatreName(theatreName);
	}

	@Override
	public List<String> getAllCities() {
		return theatreRepository.getAllCities();
	}
	

}
