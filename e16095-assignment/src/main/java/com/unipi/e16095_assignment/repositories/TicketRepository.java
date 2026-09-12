package com.unipi.e16095_assignment.repositories;

import com.unipi.e16095_assignment.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {
}
