package com.spring.ai.service;

import com.spring.ai.entity.Ticket;
import com.spring.ai.repository.TicketRepo;
import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
public class TicketServiceImpl implements TicketService{

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }
    @Override
    @Transactional
    public Ticket creatTicket(Ticket ticket) {
        ticket.setId(null);
        return ticketRepo.save(ticket);
    }

    @Override
    @Transactional
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicket(Long ticketId) {
        return ticketRepo.findById(ticketId);
    }




    @Override
    public void DeleteTicket(String emailId) {
        Ticket ticket = ticketRepo.findByEmail(emailId);
        ticketRepo.delete(ticket);
    }

    @Override
    public Ticket getTicketByEmailId(String emailId) {
        return ticketRepo.findByEmail(emailId);
    }
}
