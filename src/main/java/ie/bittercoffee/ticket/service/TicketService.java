package ie.bittercoffee.ticket.service;

import java.util.List;

import ie.bittercoffee.ticket.entity.Ticket;

public interface TicketService
{
	public List<Ticket> getTickets();
	
	public Ticket getTicket(int id);
	
	public void addTicket(Ticket ticket);
}