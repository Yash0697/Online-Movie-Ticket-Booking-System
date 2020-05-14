package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Show;

@Service
public interface ScreenService {

	public Show searchShow(String showName );

	public String addScreen(Screen screen);

	public List<Screen> showAllScreens();

	public List<Show> getShowsInScreen(int screenId);

	public Optional<Show> findShowInScreen(int screenId, int showId);

	public Optional<Screen> findById(int screenId);
}
