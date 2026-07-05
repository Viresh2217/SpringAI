package com.spring.ai.repository;

import com.spring.ai.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketRepo extends JpaRepository<Ticket,Long> {

    Ticket findByEmail(String email);
}
