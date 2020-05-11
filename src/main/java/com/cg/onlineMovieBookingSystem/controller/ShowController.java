package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;
import com.cg.onlineMovieBookingSystem.service.ShowService;


@RestController
@RequestMapping(value="/show")
public class ShowController {

	@Autowired
	ShowService showService;
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/all")
	public List<Show> showAllShows(){
		return showService.showAllSeats();
	}
	
	@PostMapping("/addShow")
	public void addShow(@RequestBody Show show){
		showService.addShow(show);
	}
	
	
}
