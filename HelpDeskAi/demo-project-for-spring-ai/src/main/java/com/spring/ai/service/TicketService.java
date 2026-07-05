package com.spring.ai.service;

import com.spring.ai.entity.Ticket;

import java.util.Optional;

public interface TicketService {

    Ticket creatTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    Optional<Ticket> getTicket(Long ticketId);

    void DeleteTicket(String emailId);

    Ticket getTicketByEmailId(String emailId);

}
