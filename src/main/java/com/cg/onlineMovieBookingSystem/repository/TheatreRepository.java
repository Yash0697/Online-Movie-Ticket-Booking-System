package com.cg.onlineMovieBookingSystem.repository;

import java.util.List;
import java.util.Optional;

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
	
//	@Query(value="select * from Screen s where screen_id="
//			+ "(select list_of_screens_screen_id from theatre_list_of_screens"
//			+ " where theatre_theatre_id=?1 and list_of_screens_screen_id=?2)", nativeQuery = true)
//	@Query(value="select s from Screen s where s.screenId=("
//			+ "select ls.screenId from Theatre.listOfScreens ls where )")
//	public Screen findByListOfScreens1( int theatreId, int screenId);
}
