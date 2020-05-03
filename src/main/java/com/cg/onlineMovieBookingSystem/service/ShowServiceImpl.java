package com.cg.onlineMovieBookingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.dao.ShowDao;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowDao showDao;
	
	@Override
	public List<Seat> showSeatsInShow(int showId) {
		return showDao.showSeatsInShow(showId);
	}

	@Override
	public List<Show> showAllSeats() {
		return showDao.showAllSeats();
	}

	@Override
	public void addShow(Show show) {
		showDao.addShow(show);
		
	}

}
