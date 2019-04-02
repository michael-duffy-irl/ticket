package ie.bittercoffee.ticket.rest;

/*
 * A Class to allow me to throw a CustomTicketException
 * 
 */
public class CustomTicketException extends RuntimeException
{
	public CustomTicketException(String arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CustomTicketException(Throwable arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CustomTicketException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
}
