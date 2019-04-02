package ie.bittercoffee.ticket.dao;

import java.util.List;

import ie.bittercoffee.ticket.entity.Ticket;

public interface TicketDAO
{
	public List<Ticket> getTickets();
	
	public Ticket getTicket(int id);

	public void addTicket(Ticket ticket);	
}
