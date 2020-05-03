package com.cg.onlineMovieBookingSystem.dao;

import java.util.List;

import com.cg.onlineMovieBookingSystem.Entity.Show;

public interface ScreenDao {

	public List<Show> findShowByShowName(Show show);

}
