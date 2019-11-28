package treinamento.exception;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CategoriaRestCostimizado> handleAnyException(Exception ex, WebRequest request) {
		CategoriaRestCostimizado errorMessage = new CategoriaRestCostimizado(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<CategoriaRestCostimizado> IncorrectPassword(Exception ex, WebRequest request) {
		CategoriaRestCostimizado errorMessage = new CategoriaRestCostimizado(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
