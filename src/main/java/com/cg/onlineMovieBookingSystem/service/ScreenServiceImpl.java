package com.cg.onlineMovieBookingSystem.service;

import java.util.Iterator;
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
	ShowService showService;
	
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
	public String addScreen(Screen screen) {
		List<Show> shows = screen.getShowList();
		Iterator<Show> it = shows.iterator();
		while(it.hasNext()){
			Show show = it.next();
			if(showRepository.findById(show.getShowId()).isPresent()){
				return "SHOW ALREADY EXISTS";
			}
			else{
				showService.addShow(show);
			}
		}
		screenDao.addScreen(screen);
		return "SCREEN ADDED SUCCESSFULLY";
		
	}

	@Override
	public List<Screen> showAllScreens() {
		return screenDao.showAllScreens();
	}

	@Override
	public List<Show> getShowsInScreen(int screenId) {
		return screenDao.getShowsInScreen(screenId);
	}

}
