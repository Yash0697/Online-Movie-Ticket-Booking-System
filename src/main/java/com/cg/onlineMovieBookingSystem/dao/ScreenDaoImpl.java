package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.repository.ScreenRepository;

@Component
public class ScreenDaoImpl implements ScreenDao {

	@Autowired
	ScreenRepository screenRepository;
	
	@Override
	public List<Show> findShowByShowName(Show show) {
		return screenRepository.findByshowList1(show.getShowName());
	}

	@Override
	public void addScreen(Screen screen) {
		screenRepository.save(screen);
		
	}

	@Override
	public List<Screen> showAllScreens() {
		return (List<Screen>) screenRepository.findAll();
	}

	@Override
	public List<Show> getShowsInScreen(int screenId) {
		return screenRepository.getShowsInScreen(screenId);
	}

}
