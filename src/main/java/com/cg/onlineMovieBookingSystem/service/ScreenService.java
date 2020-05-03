package com.cg.onlineMovieBookingSystem.service;

import org.springframework.stereotype.Service;

import com.cg.onlineMovieBookingSystem.Entity.Show;

@Service
public interface ScreenService {

	public Show searchShow(String showName );
}
