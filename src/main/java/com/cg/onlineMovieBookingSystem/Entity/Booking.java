package com.cg.onlineMovieBookingSystem.Entity;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="Booking")
public class Booking {

	@Id
	@Column(name="bookingId")
	private int bookingId;
	
	
	private int movieId;
	
	@ManyToOne
	private Show showRef;
	
	@Column(name="showId")
	private int showId;
	
	@Column(name="bookingDate")
	private LocalDate bookingDate;
	
	
	@Column(name="transactionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	@Column(name="totalCost")
	private double totalCost;
	
	@OneToMany(targetEntity=Seat.class)
	private List<Seat> seatList;
	
	int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Booking() {
		
	}

	public Booking(int bookingId, int movieId, Show showRef, int showId, LocalDate bookingDate,
			int transactionId, double totalCost, List<Seat> seatList) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showRef = showRef;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.seatList = seatList;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Show getShowRef() {
		return showRef;
	}

	public void setShowRef(Show showRef) {
		this.showRef = showRef;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}
	
	public double calculateTotalCost(){
		
		double amount = 0;
		Iterator<Seat> seatsIterator = this.getSeatList().iterator();
		while(seatsIterator.hasNext()){
			Seat seat = seatsIterator.next();
			amount += seat.getSeatPrice();
		}
		return amount;
	}
	
	public boolean cancelTickets(List<Seat> seats){
		Iterator<Seat> seatsIterator = this.getSeatList().iterator();
		while(seatsIterator.hasNext()){
			Seat seat = seatsIterator.next();
			seat.setSeatStatus(BookingStatus.AVAILABLE);
			return true;
		}
		return false;
	}
}
