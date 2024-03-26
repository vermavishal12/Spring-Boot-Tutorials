package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import railway.com.example.RailwayAndMeal.Entity.Ticket;

@Service
public class RailwayService {

	public List<Ticket> list = new ArrayList<>();
	public Map<Long,Ticket> ticketMap = new HashMap<>();
	
	/** This function adds a ticket to a list and associates it with a PNR in a ticket map 
	    for efficient retrieval. **/
	public void addTicket(Ticket ticket) {
		this.list.add(ticket);
		this.ticketMap.put(ticket.getPnr(), ticket);
		return;
	}
	
	/** This function returns a list of all tickets stored in the class. **/
	public List<Ticket> getAllTickets() {		
		return this.list;
	}
	
	/** This method retrieves a ticket based on its unique PNR from ticketmap. **/ 
	public Ticket getTicketByPnr(long pnr) {
		return this.ticketMap.get(pnr);
	}
		
}