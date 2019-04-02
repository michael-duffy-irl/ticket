# Read me for take home test for Poppulo

### Endpoints

GET  /hello					: initial endpoint to insure rest interface is running (always seems fun)
POST /ticket				: endpoint to create a single ticket
POST /ticket/{count}		: endpoint to create count number of tickets
GET  /ticket				: endpoint to get a list of all tickets
GET  /ticket/{id}			: endpoint to get a ticket with given id
PUT  /ticket/{id}			: endpoint to add a single line to a ticket with given id
PUT  /ticket/{id}/{count}	: endpoint to add count number of lines to a ticket with given id
PUT  /status/{id}			: endpoint to set the checked statue of a ticket with given id

### Points of Interest

For who may be reading this. This application is a spring boot application, so the class 
/ticket/src/main/java/ie/bittercoffee/ticket/TicketApplication.java just needs to be run as a Java application 
in your IDE 

the following classes will be of note:

/ticket/src/main/java/ie/bittercoffee/ticket/rest/TicketController.java
	main controller with all of the code for the endpoints

/ticket/src/main/java/ie/bittercoffee/ticket/entity/Line.java
	class where the logic of calculating the results is implemented
	

/ticket/src/main/java/ie/bittercoffee/ticket/entity/SortByResult.java
	class that defines the sort for lines
/ticket/src/main/java/ie/bittercoffee/ticket/entity/Ticket.java
	class where the sort is implemented
	
### Notes 

In the hopes not to waste anyones I was unsure about what was wanted in regards to the status of a ticket 
and what it ment in terms of the result variable. So I implemented it as a flag that stops the addition of 
any lines and the flag is set to true (checked) with the /status/{id} endpoint. If this is not the intended
implementation please given me some feed back on it as I would like to complete it as intended 
(tho NOT for re-submittal, unless requested).