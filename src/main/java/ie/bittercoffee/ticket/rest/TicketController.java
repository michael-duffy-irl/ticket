package ie.bittercoffee.ticket.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.bittercoffee.ticket.entity.Line;
import ie.bittercoffee.ticket.entity.Ticket;
import ie.bittercoffee.ticket.service.TicketService;

/*
 * Implementation of Take home Test for Poppulo
 * 
 *  Rest Service with the following endpoints
 *  GET  /hello					: initial endpoint to insure rest interface is running (always seems fun)
 *  POST /ticket				: endpoint to create a single ticket
 *  POST /ticket/{count}		: endpoint to create count number of tickets
 *  GET  /ticket				: endpoint to get a list of all tickets
 *  GET  /ticket/{id}			: endpoint to get a ticket with given id
 *  PUT  /ticket/{id}			: endpoint to add a single line to a ticket with given id
 *  PUT  /ticket/{id}/{count}	: endpoint to add count number of lines to a ticket with given id
 *  PUT  /status/{id}			: endpoint to set the checked statuse of a ticket with given id 
 *  
 */
@RestController
public class TicketController
{
	@Autowired
	TicketService ticketService;
	
	int ticketLimit = 1000; //the maximum number of tickets that can be created useing a single put
	int lineLimit = 1000; //the maximum number of lines that can be created useing a single put
	
	//Endpoint to insure rest interface is running 
	@GetMapping("/hello")
	public String helloTime()
	{
		return "hi there the time is "+LocalDateTime.now();
	}
	
	
	@PostMapping("/ticket")
	public List<Ticket> addTicket()
	{
		Ticket ticket = new Ticket();
		Line line = new Line();
		
		ticket.addLine(line);
		ticketService.addTicket(ticket);
		
		return ticketService.getTickets();
	}
	
	@PostMapping("/ticket/{count}")
	public List<Ticket> addTickets(@PathVariable int count)
	{
		//simple limiter on each put 
		if(count < 0 || count > ticketLimit)
		{
			throw new CustomTicketException("Number of Tickets to create must be between 0 and 1000");
		}
		
		for(int i= 0; i< count; i++)
		{
			Ticket ticket = new Ticket();
			Line line = new Line();
			
			ticket.addLine(line);
			ticketService.addTicket(ticket);
		}
		
		
		return ticketService.getTickets();
	}
	
	@GetMapping("/ticket")
	public List<Ticket> getTickets()
	{
		List<Ticket> tickets = ticketService.getTickets();
		
		if(tickets == null)
		{
			throw new CustomTicketException("No tickets available");
		}
		
		return tickets;
	}
	
	@GetMapping("/ticket/{id}")
	public Ticket getTicket(@PathVariable int id)
	{	
		Ticket ticket = ticketService.getTicket(id);
		if(ticket == null)
		{
			throw new CustomTicketException("No ticket available with id - "+id);
		}
		return ticket;
	}
	
	@PutMapping("/ticket/{id}")
	public Ticket addTicketLine(@PathVariable int id)
	{
		Ticket ticket = ticketService.getTicket(id);
		
		if(ticket == null)
		{
			throw new CustomTicketException("No ticket available with id - "+id);
		}
		
		if(ticket.isChecked())
		{
			throw new CustomTicketException("Ticket with id "+id+" has been checked and is locked");
		}
		
		Line line = new Line();
		
		ticket.addLine(line);
		
		ticket.sortLines();
		
		return ticket;
	}
	
	@PutMapping("/ticket/{id}/{count}")
	public Ticket addTicketLines(@PathVariable int id,@PathVariable int count)
	{
		Ticket ticket = ticketService.getTicket(id);
		
		if(ticket == null)
		{
			throw new CustomTicketException("No ticket available with id - "+id);
		}
		
		if(ticket.isChecked())
		{
			throw new CustomTicketException("Ticket with id "+id+" has been checked and is locked");
		}
		
		//Simple limiter on each put
		if(count < 0 || count > lineLimit)
		{
			throw new CustomTicketException("Number of lines to create must be between 0 and 1000");
		}
		
		
		for(int i= 0; i< count; i++)
		{				
			Line line = new Line();
			
			ticket.addLine(line);
		}
		
		ticket.sortLines();
		
		return ticket;
	}
	
	@PutMapping("/status/{id}")
	public Ticket getStatus(@PathVariable int id)
	{
		Ticket ticket = ticketService.getTicket(id);
		
		if(ticket == null)
		{
			throw new CustomTicketException("No ticket available with id - "+id);
		}
		
		ticket.setChecked(true);
		
		return ticket;
	}
}
