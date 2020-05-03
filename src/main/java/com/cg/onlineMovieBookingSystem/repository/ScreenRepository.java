package com.cg.onlineMovieBookingSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Screen;
import com.cg.onlineMovieBookingSystem.Entity.Show;

@Repository
public interface ScreenRepository  extends CrudRepository<Screen, Integer> {

	@Query(value = "SELECT sh FROM Screen sc join sc.showList sh where sh.showName= :showName")
	public List<Show> findByshowList1(@Param("showName") String showName);

	@Query(value="select sh from Screen sc join sc.showList sh where sc.screenId= :screenId and sh.showId= :showId")
	public Optional<Show> findShowInScreen(@Param("screenId") int screenId, @Param("showId") int showId);
}
