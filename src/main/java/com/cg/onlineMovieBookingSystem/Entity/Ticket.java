package com.cg.onlineMovieBookingSystem.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticketId")
	private int ticketId;
	
	@Column(name="noOfSeats")
	private int noOfSeats;
	
	@ElementCollection
	private List<String> seatNames;
	
	@Column(name="ticketStatus")
	private boolean ticketStatus;
	
	@Column(name="screenName")
	private String screenName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking", referencedColumnName = "bookingId")
    private Booking booking;

	public Ticket() {
	}

	public Ticket(int ticketId, int noOfSeats, List<String> seatNames, boolean ticketStatus, String screenName,
			Booking booking) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatNames = seatNames;
		this.ticketStatus = ticketStatus;
		this.screenName = screenName;
		this.booking = booking;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<String> getSeatName() {
		return seatNames;
	}

	public void setSeatName(List<String> seatNames) {
		this.seatNames = seatNames;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	
}
