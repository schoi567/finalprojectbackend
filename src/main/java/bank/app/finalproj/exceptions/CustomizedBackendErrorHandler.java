package bank.app.finalproj.exceptions;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import bank.app.finalproj.entity.Customers;

@RestControllerAdvice
public class CustomizedBackendErrorHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity handleAllException(Exception ex, WebRequest request) throws Exception {
		BackendErrorResponse errorResponse = 
				new BackendErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundExceptions.class)
	public final ResponseEntity<Customers> handleTodoNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
		BackendErrorResponse errorResponse = 
				new BackendErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		BackendErrorResponse errorResponse = 
				new BackendErrorResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
