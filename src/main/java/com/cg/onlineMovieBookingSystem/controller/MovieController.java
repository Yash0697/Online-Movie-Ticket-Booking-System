package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.service.MovieService;

@RestController
@RequestMapping(value="movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	
	
	@GetMapping("/all")
	public List<Movie> showAllMovies(){
		return movieService.showAllMovies();
	}
	
	@PostMapping("/addMovie")
	public void saveSeat(@RequestBody Movie Movie)
	{
		movieService.saveMovie(Movie);
	}
}
