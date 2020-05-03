package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;
import com.cg.onlineMovieBookingSystem.dao.TheatreDao;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;
import com.cg.onlineMovieBookingSystem.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Override
	public Movie searchMovie(String movieName) {
		Optional<Movie> movieOptional = movieRepository.findByMovieName(movieName);
		if(movieOptional.isPresent()){
		List<Movie> movies = theatreDao.findMovieByName(movieOptional.get());
		if(movies.size()>0){
			return movies.get(0);
		}
		else
			return null;
		}
		else
			return null;
	}

	@Override
	public Screen searchScreen(int theatreId, int screenId) {
		Screen screen = theatreDao.searchScreen(theatreId, screenId);
		if(screen != null)
		{
			return screen;
		}
		return null;
	}

	@Override
	public Theatre selectByTheatre(String theatreName) {
		Optional<Theatre> theatreOptional = theatreDao.selectByTheatreName(theatreName);
		if(theatreOptional.isPresent()){
			return theatreOptional.get();
		}
		else
			return null;
	}

	@Override
	public List<Theatre> selectByCityName(String cityName) {
		List<Theatre> theatres = theatreDao.selectByCity(cityName);
		return theatres;
	}

	@Override
	public List<Movie> findMoviesInTheatre(int theatreId) {
		Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
		if(theatreOptional.isPresent()){
			return theatreOptional.get().getListOfMovies();
		}
		return null;
	}

	@Override
	public List<Screen> findScreensInTheatre(int theatreId) {
		Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
		if(theatreOptional.isPresent()){
			return theatreOptional.get().getListOfScreens();
		}
		return null;
	}

	
}
