package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;
import com.cg.onlineMovieBookingSystem.dao.TheatreDao;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;
import com.cg.onlineMovieBookingSystem.repository.ScreenRepository;
import com.cg.onlineMovieBookingSystem.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	ShowService showService;
	
	@Override
	public Movie searchMovie(int theatreId, String movieName) {
		Optional<Movie> movieOptional = movieRepository.findByMovieName(movieName);
		if(movieOptional.isPresent()){
		List<Movie> movies = theatreDao.findMovieByName(theatreId, movieOptional.get());
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

	@Override
	public List<Show> findShowsInTheatre(int theatreId, int screenId) {
		Optional<Screen> screenOptional = theatreRepository.findScreenInTheatre(theatreId, screenId);
		if(screenOptional.isPresent()){
			return screenOptional.get().getShowList();
		}
		return null;
	}

	@Override
	public Show selectShow(int theatreId, int screenId, int showId) {
		Optional<Screen> screenOptional = theatreRepository.findScreenInTheatre(theatreId, screenId);
		if(screenOptional.isPresent()){
			Optional<Show> showOptional = screenRepository.findShowInScreen(screenId, showId);
			if(showOptional.isPresent()){
				return showOptional.get();
			}
		}
		return null;
	}

	@Override
	public Screen selectScreen(int theatreId, int screenId) {
		Optional<Screen> screenOptional = theatreRepository.findScreenInTheatre(theatreId, screenId);
		if(screenOptional.isPresent()){
			return screenOptional.get();
		}
		return null;
	}

	@Override
	public List<String> showCities() {
		List<String> cities = theatreDao.getAllCities();
		return cities;
	}

	@Override
	public List<Seat> showSeats(int theatreId, int screenId, int showId) {
		return showService.showSeatsInShow(showId);
	}

	
}
