package com.cg.onlineMovieBookingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Booking;


@Repository
public interface BookingRepository  extends CrudRepository<Booking, Integer>{

}
