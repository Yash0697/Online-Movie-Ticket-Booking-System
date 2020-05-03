package com.cg.onlineMovieBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Show;
import com.cg.onlineMovieBookingSystem.service.ScreenService;

@RestController
@RequestMapping(value="/screen")
public class ScreenController {

	@Autowired
	ScreenService screenService;
	
	@GetMapping("/searchShow")
	public String searchShow(@RequestParam("showName") String showName){
		Show show = screenService.searchShow(showName);
		if(show != null){
			return show.getShowName()+"";
		}
		else
			return "ERROR:NO SHOW FOR GIVEN NAME";
	}
	
}
