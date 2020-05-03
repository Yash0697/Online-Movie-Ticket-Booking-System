package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;
import com.cg.onlineMovieBookingSystem.repository.TheatreRepository;
import com.cg.onlineMovieBookingSystem.service.TheatreService;

@RestController
@RequestMapping(value="/theatre")
public class TheatreController {

	@Autowired
	TheatreService theatreService;
	
	@Autowired
	TheatreRepository repo;
	
	@GetMapping("/all")
	public List<Theatre> showAll(){
		return (List<Theatre>) repo.findAll();
		
	}
	@GetMapping("/movie")
	public Movie searchMovie(@RequestParam("movieName") String movieName){
		return  theatreService.searchMovie(movieName);
	}
	
	@GetMapping("/screens")
	public Screen searchScreen(@RequestParam("theatreId")int theatreId, @RequestParam("screenId") int screenId){
		return theatreService.searchScreen(theatreId, screenId);
	}
}
