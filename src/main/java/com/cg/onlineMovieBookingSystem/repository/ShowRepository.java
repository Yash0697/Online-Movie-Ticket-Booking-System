package com.cg.onlineMovieBookingSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Seat;
import com.cg.onlineMovieBookingSystem.Entity.Show;


@Repository
public interface ShowRepository  extends CrudRepository<Show, Integer>{

	@Query(value="select s from Show s where s.showName=:showName")
	 Optional<Show> findByName(@Param("showName") String showName);
	
	@Query(value="select seats from Show s join s.seats seats where s.showId= :showId")
	List<Seat> showSeatsInShow(@Param("showId") int showId);
}
