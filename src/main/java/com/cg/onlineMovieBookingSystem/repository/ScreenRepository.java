package com.cg.onlineMovieBookingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Screen;

@Repository
public interface ScreenRepository  extends CrudRepository<Screen, Integer> {

}
