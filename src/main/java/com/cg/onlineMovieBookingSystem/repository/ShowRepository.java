package com.cg.onlineMovieBookingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Show;


@Repository
public interface ShowRepository  extends CrudRepository<Show, Integer>{

	@Query(value="select s from Show s where s.showName=:showName")
	 Optional<Show> findByName(@Param("showName") String showName);
}
