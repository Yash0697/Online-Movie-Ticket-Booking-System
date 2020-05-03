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
import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;
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
	@GetMapping("/movie/{theatre}/")
	public Movie searchMovie(@PathVariable("theatre") int theatreId, @RequestParam("movieName") String movieName){
		return  theatreService.searchMovie(theatreId, movieName);
	}
	
	@GetMapping("/screen/{theatre}/")
	public Screen searchScreen(@PathVariable("theatre") int theatreId, @RequestParam("screenId") int screenId){
		return theatreService.searchScreen(theatreId, screenId);
	}
	
	@GetMapping("/showCities")
	public List<String> showCities(){
		return theatreService.showCities();
	}
	
	@GetMapping("/selectByCity")
	public List<Theatre> selectByCity(@RequestParam("cityName")String cityName){
		return theatreService.selectByCityName(cityName);
	}
	
	@GetMapping("/selectByTheatreName")
	public Theatre selectByTheatreName(@RequestParam("theatreName")String theatreName){
		return theatreService.selectByTheatre(theatreName);
	}
	
	@GetMapping("/getListOfMovies/{theatre}")
	public List<Movie> getListOfMovies(@PathVariable("theatre") int theatreId){
		return theatreService.findMoviesInTheatre(theatreId);
	}
	
	@GetMapping("/getListOfScreens/{theatre}")
	public List<Screen> getListOfScreens(@PathVariable("theatre") int theatreId){
		return theatreService.findScreensInTheatre(theatreId);
	}
	
	
	@GetMapping("/getScreen/{theatre}/{screen}")
	public Screen selectScreen(@PathVariable("theatre") int theatreId, @PathVariable("screen") int screenId){
		return theatreService.selectScreen(theatreId, screenId);
	}
	
	@GetMapping("/getShows/{theatre}/{screen}")
	public List<Show> getShows(@PathVariable("theatre") int theatreId, @PathVariable("screen") int screenId){
		return theatreService.findShowsInTheatre(theatreId, screenId);
	}
	
	@GetMapping("/getShow/{theatre}/{screen}/{show}")
	public Show selectShow(@PathVariable("theatre") int theatreId, @PathVariable("screen") int screenId, @PathVariable("show") int showId){
		return theatreService.selectShow(theatreId, screenId, showId);
	}
	
	@GetMapping("/getSeats/{theatre}/{screen}/{show}")
	public List<Seat> showSeats(@PathVariable("theatre") int theatreId, @PathVariable("screen") int screenId, @PathVariable("show") int showId){
		return theatreService.showSeats(theatreId, screenId, showId);
	}
}
