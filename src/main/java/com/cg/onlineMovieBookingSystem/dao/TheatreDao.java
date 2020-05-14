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
public List<Theatre> findAll();
public Optional<Theatre> findById(int theatreId);
public Optional<Screen> findScreenInTheatre(int theatreId, int screenId);
public void save(Theatre theatre);
public Optional<Movie> findMovieInTheatre(String movieName);
public Optional<Theatre> findByScreenId(int screenId);
public List<Movie> findMovieByTheaterName1(String theatreName);

public List<Movie> findTheatreByTheaterCity1(String theatreCity);
public List<String> findAllTheatres();

}
