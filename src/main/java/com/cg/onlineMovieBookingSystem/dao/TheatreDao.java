package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;


public interface TheatreDao {
public List<Movie> findMovieByName(Movie movie);
public Screen searchScreen(int theatreId, int screenId);
public List<Theatre> selectByCity(String cityName);
public Optional<Theatre> selectByTheatreName(String theatreName);

}
