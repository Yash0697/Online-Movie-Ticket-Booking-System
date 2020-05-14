package com.cg.onlineMovieBookingSystem.service;

import java.util.Iterator;
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


@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	MovieService movieService;
	
	
	@Autowired
	ScreenService screenService;
	
	@Autowired
	ShowService showService;
	
	@Override
	public Movie searchMovie(int theatreId, String movieName) {
		Optional<Movie> movieOptional = movieService.findByMovieName(movieName);
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
		Optional<Theatre> theatreOptional = theatreDao.findById(theatreId);
		if(theatreOptional.isPresent()){
			return theatreOptional.get().getListOfMovies();
		}
		return null;
	}

	@Override
	public List<Screen> findScreensInTheatre(int theatreId) {
		Optional<Theatre> theatreOptional = theatreDao.findById(theatreId);
		if(theatreOptional.isPresent()){
			return theatreOptional.get().getListOfScreens();
		}
		return null;
	}

	@Override
	public List<Show> findShowsInTheatre(int theatreId, int screenId) {
		Optional<Screen> screenOptional = theatreDao.findScreenInTheatre(theatreId, screenId);
		if(screenOptional.isPresent()){
			return screenOptional.get().getShowList();
		}
		return null;
	}

	@Override
	public Show selectShow(int theatreId, int screenId, int showId) {
		Optional<Screen> screenOptional = theatreDao.findScreenInTheatre(theatreId, screenId);
		if(screenOptional.isPresent()){
			Optional<Show> showOptional = screenService.findShowInScreen(screenId, showId);
			if(showOptional.isPresent()){
				return showOptional.get();
			}
		}
		return null;
	}

	@Override
	public Screen selectScreen(int theatreId, int screenId) {
		Optional<Screen> screenOptional = theatreDao.findScreenInTheatre(theatreId, screenId);
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

	@Override
	public List<Movie> selectMoviesByCityName(String cityName) {
		return theatreDao.getMoviesByCityName(cityName);
	}

	@Override
	public String addTheatre(Theatre theatre) {
		List<Screen> screens = theatre.getListOfScreens();
		Iterator<Screen> it = screens.iterator();
		while(it.hasNext()){
			Screen screen = it.next();
			if(screenService.findById(screen.getScreenId()).isPresent()){
				return "Screen Already Exists";
			}
			else{
				screenService.addScreen(screen);
			}
		}
		theatreDao.save(theatre);
		return "THEATRE ADDED";
	}

	@Override
	public List<Theatre> selectByMovieName(String movieName) {
		return theatreDao.selectByMovieName(movieName);
	}

	@Override
	public List<Show> selectByMovieAndTheatre(String movieName, String theatreName) {
		Optional<Theatre> theatreOptional = theatreDao.selectByTheatreName(theatreName);
		Optional<Movie> movieOptional = theatreDao.findMovieInTheatre(movieName);
		if(theatreOptional.isPresent() && movieOptional.isPresent()){
			int movieId = movieOptional.get().getMovieId();
			int theatreId = theatreOptional.get().getTheatreId();
			List<Show> shows = showService.findShowsByMovieAndTheatre(movieId, theatreId);
			return shows;
		}
		return null;
	}

	@Override
	public List<Theatre> findAll() {
		return theatreDao.findAll();
	}

	@Override
	public Optional<Theatre> findByScreenId(int screenId) {
		return theatreDao.findByScreenId(screenId);
	}

	@Override
	public List<Movie> searchMovieByTheater(String theatreName) {
		
		return theatreDao.findMovieByTheaterName1(theatreName);
	}

	@Override
	public List<Movie> searchTheaterByMovie(String theatreCity) {
		
		return theatreDao.findTheatreByTheaterCity1(theatreCity);
	}

	@Override
	public List<String> findAllCities() {
		return theatreDao.getAllCities();
	}

	@Override
	public List<String> findAllTheatres() {
		return theatreDao.findAllTheatres();
	}
	
}
