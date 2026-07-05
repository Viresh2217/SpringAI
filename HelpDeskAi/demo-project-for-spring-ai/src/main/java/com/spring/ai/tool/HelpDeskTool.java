package com.spring.ai.tool;

import com.spring.ai.entity.Ticket;
import com.spring.ai.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpDeskTool {


    @Autowired
    private TicketService ticketService;

    //Create Ticket Tool
    @Tool(description = "Create a new help desk ticket. Requires fields: email, priority, category, description.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket object with email, priority, category, description") Ticket ticket) {
        return ticketService.creatTicket(ticket);
    }


    // Update Ticket Tool
    @Tool(description = "this tool helps to update ticket")
    public Ticket updateTicketTool(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket){
        return ticketService.updateTicket(ticket);
    }


    //Get Ticket Tool
    @Tool(description = "This tool helps to get ticket by username.")
    public Ticket getTicketByUserName(@ToolParam(description = " email id whose ticket is required ") String emailid) {
        return ticketService.getTicketByEmailId(emailid);
    }

    //Get Current time
    @Tool(description = "This tool helps to get current system time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }



}
