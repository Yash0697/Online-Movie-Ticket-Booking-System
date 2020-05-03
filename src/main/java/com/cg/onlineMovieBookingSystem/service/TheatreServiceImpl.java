package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.dao.TheatreDao;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	MovieRepository movieRepository;
	
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
		System.out.println("searchScreen--------------------------------------------------------------------------------------------");
		Screen screen = theatreDao.searchScreen(theatreId, screenId);
		if(screen != null)
		{
			return screen;
		}
		return null;
	}

	
}
