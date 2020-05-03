package com.cg.onlineMovieBookingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Show;


@Repository
public interface ShowRepository  extends CrudRepository<Show, Integer>{

}
