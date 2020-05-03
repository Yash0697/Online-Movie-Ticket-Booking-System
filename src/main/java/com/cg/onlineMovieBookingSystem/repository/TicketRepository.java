package com.cg.onlineMovieBookingSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineMovieBookingSystem.Entity.Ticket;


@Repository
public interface TicketRepository  extends CrudRepository<Ticket, Integer> {

}
