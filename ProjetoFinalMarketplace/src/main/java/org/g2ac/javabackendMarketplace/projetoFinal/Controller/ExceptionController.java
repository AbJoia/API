package org.g2ac.javabackendMarketplace.projetoFinal.Controller;

import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.DataNotFoundException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.SolicitacaoInvalidaException;
import org.g2ac.javabackendMarketplace.projetoFinal.Exceptions.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String> trataDataNotFound(DataNotFoundException exception) {
		String msg = String.format("Registro com Id %d não foi encontrado", exception.getId());
		return ResponseEntity
				.notFound()
				.header("x-erro-msg", msg).header("x-erro-code", "DATA_NOT_FOUND")
				.header("x-erro-value", "" + exception.getId())
				.build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> trataMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return ResponseEntity
				.badRequest()
				.header("x-erro-msg", exception.getMsg())
				.header("x-erro-code", "DADOS_PARA_REGISTRO_INVALIDOS")
				.build();
	}
	
	
	@ExceptionHandler(SolicitacaoInvalidaException.class)
	public String trataDeleteInvalidoException(SolicitacaoInvalidaException exception) {
		return exception.getMsg();
	}

}
