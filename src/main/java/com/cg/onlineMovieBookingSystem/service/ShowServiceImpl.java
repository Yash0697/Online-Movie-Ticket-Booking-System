package com.cg.onlineMovieBookingSystem.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.BookingStatus;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;
import com.cg.onlineMovieBookingSystem.dao.ShowDao;
import com.cg.onlineMovieBookingSystem.service.SeatService;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowDao showDao;
	
	@Autowired
	SeatService seatService;
	
	@Autowired
	ScreenService screenService;
	
	@Autowired
	TheatreService theatreService;
	
	@Override
	public List<Seat> showSeatsInShow(int showId) {
		return showDao.showSeatsInShow(showId);
	}

	@Override
	public List<Show> showAllSeats() {
		return showDao.showAllSeats();
	}

	@Override
	public boolean addShow(Show show) {
		int i;
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ADDING SHOW Now");
		Optional<Show> showOptional = showDao.findById(show.getShowId());
		if(showOptional.isPresent()){
			return false;
		}
		else{
			int screenId = show.getScreenId();
			Screen screen = screenService.findById(screenId).get();
			int noOfSeats = screen.getColumns() * screen.getRows1();
			List<Seat> seats= show.getSeats();
			for(i = 0; i < noOfSeats; i++){
				seats.add(new Seat(i, BookingStatus.AVAILABLE, 800));
			}
				Optional<Theatre> theatreOptional = theatreService.findByScreenId(screen.getScreenId());
				if(theatreOptional.isPresent()){
					show.setTheatreId(theatreOptional.get().getTheatreId());
				}
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ADDING SHOW");
			showDao.addShow(show);
			return true;
		}
		
	}

	@Override
	public List<Show> findShowsByMovieAndTheatre(int movieId, int theatreId) {
		return showDao.findShowsByMovieAndTheatre(movieId, theatreId);
	}

	@Override
	public Optional<Show> findByName(String showName) {
		return showDao.findByName(showName);
	}

	@Override
	public Optional<Show> findById(int showId) {
		return showDao.findById(showId);
	}

	@Override
	public void deleteById(int id) {
		showDao.deleteById(id);
		
	}

}
