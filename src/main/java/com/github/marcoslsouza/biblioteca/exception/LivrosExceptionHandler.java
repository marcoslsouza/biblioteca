package com.github.marcoslsouza.biblioteca.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LivrosExceptionHandler extends ResponseEntityExceptionHandler {
	
	// Tratar execoes
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
		return buildResponseEntity(HttpStatus.NOT_FOUND, exception.getMessage(), Collections.singletonList(exception.getMessage()));
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Object> handleEntityExistisException(EntityExistsException exception) {
		return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(), Collections.singletonList(exception.getMessage()));
	}
	
	// Para tratar campos obrigatorios que nao foram informados
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, 
			HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(fieldError -> errors.add("Campo " + fieldError.getField().toUpperCase() + " " 
				+ fieldError.getDefaultMessage()));
		exception.getBindingResult().getGlobalErrors().forEach(globalError -> errors.add("Objeto " + globalError.getObjectName().toUpperCase() + " " 
				+ globalError.getDefaultMessage()));
		return buildResponseEntity(HttpStatus.BAD_REQUEST, "Argumentos inválidos!", errors);
	}
	
	// Caso informe Json com formatacao invalida
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exeption,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return buildResponseEntity(HttpStatus.BAD_REQUEST, "JSON com erro na formatação!", Collections.singletonList(exeption.getLocalizedMessage()));
	}
	
	// Metodo de suporte
	private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors) {
		ApiError apiError = ApiError.builder()
				.code(httpStatus.value())
				.status(httpStatus.getReasonPhrase())
				.message(message)
				.errors(errors)
				.timestamp(LocalDateTime.now())
				.build();
		
		return ResponseEntity.status(httpStatus).body(apiError);
	}
}
