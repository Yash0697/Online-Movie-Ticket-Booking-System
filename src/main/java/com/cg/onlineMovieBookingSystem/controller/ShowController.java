package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.service.ShowService;


@RestController
@RequestMapping(value="/show")
@CrossOrigin(origins = "http://localhost:4200")
public class ShowController {

	@Autowired
	ShowService showService;
	
	@GetMapping("/all")
	public List<Show> showAllShows(){
		return showService.showAllSeats();
	}
	
	@PostMapping("/addShow")
	public ResponseEntity<?> addShow(@RequestBody Show show){
		boolean result = showService.addShow(show);
		if(result){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(path ={"delete/{id}"})
	public void deleteMovie(@PathVariable("id") int id){
		showService.deleteById(id);
	}
	
	
}
