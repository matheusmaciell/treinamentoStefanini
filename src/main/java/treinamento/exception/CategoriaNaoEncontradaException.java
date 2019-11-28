package treinamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoriaNaoEncontradaException(String msg) {

		super(msg);
	}
}
