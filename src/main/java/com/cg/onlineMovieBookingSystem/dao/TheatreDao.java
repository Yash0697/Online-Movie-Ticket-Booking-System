package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;


public interface TheatreDao {
public List<Movie> findMovieByName(Movie movie);
public Screen searchScreen(int theatreId, int screenId);
}
