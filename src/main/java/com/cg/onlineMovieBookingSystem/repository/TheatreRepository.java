package com.cg.onlineMovieBookingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Movie;
import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Theatre;


@Repository
public interface TheatreRepository  extends CrudRepository<Theatre, Integer> {
	
	@Query(value = "SELECT m FROM Theatre t join t.listOfMovies m where m.movieName= :movieName")
	public List<Movie> findByListOfMovies1(@Param("movieName") String movieName);
	
	@Query(value="select s from Theatre t join t.listOfScreens s where t.theatreId=:tid and s.screenId= :sid")
	public Screen findByListOfScreens1(@Param("tid") int theatreId, @Param("sid") int screenId); 
	
}
