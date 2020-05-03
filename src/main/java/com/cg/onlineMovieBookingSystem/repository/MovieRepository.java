package com.cg.onlineMovieBookingSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Movie;

@Repository
public interface MovieRepository  extends CrudRepository<Movie, Integer> {

	Optional<Movie> findByMovieName(String movieName);
}
