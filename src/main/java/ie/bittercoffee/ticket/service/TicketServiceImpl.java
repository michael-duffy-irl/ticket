package ie.bittercoffee.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.bittercoffee.ticket.dao.TicketDAO;
import ie.bittercoffee.ticket.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService
{
	@Autowired
	TicketDAO ticketDAO;
	
	@Override
	public List<Ticket> getTickets()
	{
		return ticketDAO.getTickets();
	}

	@Override
	public Ticket getTicket(int id)
	{
		return ticketDAO.getTicket(id);
	}

	@Override
	public void addTicket(Ticket ticket)
	{
		ticketDAO.addTicket(ticket);		
	}

}
