package com.unipi.e16095_assignment.repositories;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findTicketsBySubmittingEntityId(Long id);
}
