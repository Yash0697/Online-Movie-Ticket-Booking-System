package com.cg.onlineMovieBookingSystem.Entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Show1")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="showId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private int showId;
	
	@Column(name="showStartTime")
	private LocalTime showStartTime;
	
	@Column(name="showEndTime")
	private LocalTime showEndTime;
	
	@OneToMany(targetEntity=Seat.class)
	private List<Seat> seats;
	
	@Column(name="showName")
	private String showName;
	
	@ManyToOne
    private Movie movieName;
	
	//@ManyToOne(targetEntity=Screen.class)
	private int screenId;
	
	//@ManyToOne(targetEntity=Screen.class)
	private int theatreId;

	public Show() {
		super();
	}

	public Show(int showId, LocalTime showStartTime, LocalTime showEndTime, List<Seat> seats, String showName, Movie movieName,
			int screenId, int theatreId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.seats = seats;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theatreId = theatreId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovieName() {
		return movieName;
	}

	public void setMovieName(Movie movieName) {
		this.movieName = movieName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	//public boolean updateSeatStatus()
	
}
