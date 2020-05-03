package com.cg.onlineMovieBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.dao.ScreenDao;
import com.cg.onlineMovieBookingSystem.repository.ShowRepository;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	ScreenDao screenDao;
	
	@Override
	public Show searchShow(String showName) {
		Optional<Show> showOptional = showRepository.findByName(showName);
		if(showOptional.isPresent()){
		List<Show> shows = screenDao.findShowByShowName(showOptional.get());
		if(shows.size()>0){
			return shows.get(0);
		}
		else
			return null;
		}
		else
			return null;
	}

	@Override
	public void addScreen(Screen screen) {
		screenDao.addScreen(screen);
		
	}

	@Override
	public List<Screen> showAllScreens() {
		return screenDao.showAllScreens();
	}

}
