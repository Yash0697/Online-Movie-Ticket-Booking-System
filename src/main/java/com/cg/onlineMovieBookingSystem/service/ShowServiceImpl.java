package com.cg.onlineMovieBookingSystem.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.dao.ShowDao;
import com.cg.onlineMovieBookingSystem.service.SeatService;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowDao showDao;
	
	@Autowired
	SeatService seatService;
	
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
		List<Seat> seats= show.getSeats();
		Iterator<Seat> it = seats.iterator();
		while(it.hasNext()){
			Seat seat = it.next();
			seatService.saveSeat(seat);
		}
		showDao.addShow(show);
		
	}

	@Override
	public List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId) {
		return showDao.findShowsByMovieAndTheatre(movieId, theatreId);
	}

}
