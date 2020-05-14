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

	@Override
	public List<Movie> getMoviesByCityName(String cityName) {
		return theatreRepository.getMoviesByCityName(cityName);
	}

	@Override
	public void addTheatre(Theatre theatre) {
		theatreRepository.save(theatre);
		
	}

	@Override
	public List<Theatre> selectByMovieName(String movieName) {
		return theatreRepository.findAllByMovieName(movieName);
	}

	@Override
	public List<Screen> selectByMovieAndTheatre(String movieName, String theatreName) {
		return theatreRepository.selectByMovieAndTheatre( movieName,  theatreName);
	}

	@Override
	public List<Theatre> findAll() {
		return (List<Theatre>) theatreRepository.findAll();
	}

	@Override
	public Optional<Theatre> findById(int theatreId) {
		return theatreRepository.findById(theatreId);
	}

	@Override
	public Optional<Screen> findScreenInTheatre(int theatreId, int screenId) {
		return theatreRepository.findScreenInTheatre(theatreId, screenId);
	}

	@Override
	public void save(Theatre theatre) {
		theatreRepository.save(theatre);
		
	}

	@Override
	public Optional<Movie> findMovieInTheatre(String movieName) {
		return theatreRepository.findMovieInTheatre(movieName);
	}

	@Override
	public Optional<Theatre> findByScreenId(int screenId) {
		return theatreRepository.findByScreenId(screenId);
	}
	@Override
	public List<Movie> findMovieByTheaterName1(String theatreName) {
	
		return theatreRepository.findBytheaterName1(theatreName);
	}

	@Override
	public List<Movie> findTheatreByTheaterCity1(String theatreCity) {
		
		return theatreRepository.findBytheaterCity1(theatreCity);
	}

	@Override
	public List<String> findAllTheatres() {
		return theatreRepository.findAllTheatres();
	}


}
