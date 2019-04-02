package ie.bittercoffee.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ie.bittercoffee.ticket.entity.Ticket;

/*
 * Implementation for the TicketDAO
 */

@Repository
public class TicketDAOImpl implements TicketDAO
{
	//List to store all of the tickets for the life cycle of the application 
	private List<Ticket> tickets;
	
	@Override
	public List<Ticket> getTickets()
	{
		return tickets;
	}

	@Override
	public Ticket getTicket(int id)
	{
		Ticket ticket = null;
		
		if(tickets != null)
		{
			if(tickets.size() > id)
			{
				ticket = tickets.get(id);
			}
		}
		
		return ticket;
	}

	@Override
	public void addTicket(Ticket ticket)
	{	
		if(tickets == null)
		{
			tickets = new ArrayList<Ticket>();
		}
		
		ticket.setId(tickets.size());		
		tickets.add(ticket);
	}
}