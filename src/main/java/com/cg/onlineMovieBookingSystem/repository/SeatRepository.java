package com.cg.onlineMovieBookingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Seat;


@Repository
public interface SeatRepository  extends CrudRepository<Seat, Integer> {

}
