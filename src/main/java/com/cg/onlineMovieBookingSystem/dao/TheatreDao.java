package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;
import java.util.Optional;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;


public interface TheatreDao {
public List<Movie> findMovieByName(int theatreId, Movie movie);
public Screen searchScreen(int theatreId, int screenId);
public List<Theatre> selectByCity(String cityName);
public Optional<Theatre> selectByTheatreName(String theatreName);
public List<String> getAllCities();
public List<Movie> getMoviesByCityName(String cityName);
public void addTheatre(Theatre theatre);
public List<Theatre> selectByMovieName(String movieName);
public List<Screen> selectByMovieAndTheatre(String movieName, String theatreName);

}
