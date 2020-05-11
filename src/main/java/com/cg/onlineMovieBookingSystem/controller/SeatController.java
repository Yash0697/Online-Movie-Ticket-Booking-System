package com.cg.onlineMovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.service.SeatService;

@RestController
@RequestMapping(value="/seat")
public class SeatController {

	@Autowired
	SeatService seatService;
	
	
	@GetMapping("/all")
	public List<Seat> showAll(){
		return seatService.getAllSeats();
	}
	
	@GetMapping("/blockSeat")
	public String blockSeat(@RequestParam("seatId") int seatId){
		if(seatService.blockSeat(seatId))
			return "Blocked";
		else
			return "ERROR: THIS SEAT DOESN'T EXISTS";
	}
	
	@GetMapping("/bookSeat")
	public String bookSeat(@RequestParam("seatId") int seatId){
		if(seatService.bookSeat(seatId))
			return "Booked";
		else
			return "ERROR: THIS SEAT DOESN'T EXISTS";
	}
	
	@GetMapping("/cancelBookedSeat")
	public String cancelSeatBooking(@RequestParam("seatId") int seatId){
		if(seatService.cancelSeatBooking(seatId))
			return "Cancelled";
		else
			return "ERROR: THIS SEAT DOESN'T EXISTS";
	}
	
	@PostMapping("/addSeat")
	public void saveSeat(@RequestBody Seat seat)
	{
		seatService.saveSeat(seat);
	}
}
