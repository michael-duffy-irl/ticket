package ie.bittercoffee.ticket.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * AOP Advice to catch all exceptions and return them as TickerErrorResponse.
 */

@ControllerAdvice
public class TicketRestExceptionHandler
{
	@ExceptionHandler
	public ResponseEntity<TicketErrorResponse> handleException(Exception e)
	{
		TicketErrorResponse error = new TicketErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
