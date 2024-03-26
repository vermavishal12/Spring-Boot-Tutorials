package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TicketAlreadyExistsException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketAlreadyExistsException(String message) {
        super(message);
    }
}
