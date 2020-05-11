package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.repository.MovieRepository;
import com.cg.onlineMovieBookingSystem.service.MovieService;

@RestController
@RequestMapping(value="/movie")
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/all")
	public List<Movie> showAllMovies(){
		return movieService.showAllMovies();
	}
	
	@GetMapping("/{id}")
	public Movie getById(@PathVariable("id") int id){
		return movieRepository.findById(id).get();
	}
	
	@PostMapping("/addMovie")
	public boolean saveMovie(@RequestBody Movie movie)
	{
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++In Controller"+movie.getMovieDirector());
		if(movieService.saveMovie(movie))
			return true;
		else
			return false;
	}
	
	@DeleteMapping(path ={"delete/{id}"})
	public void deleteMovie(@PathVariable("id") int id){
		movieService.deleteById(id);
	}
}
