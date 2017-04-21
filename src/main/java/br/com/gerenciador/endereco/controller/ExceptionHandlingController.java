package br.com.gerenciador.endereco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.gerenciador.endereco.domain.FieldErro;
import br.com.gerenciador.endereco.exception.BusinessException;
import br.com.gerenciador.endereco.exception.ValidationException;
import br.com.gerenciador.endereco.domain.Error;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Error> BusinessException(BusinessException exception) {
		return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<List<FieldErro>> validationException(ValidationException exception) {
		List<FieldErro> list = new ArrayList<FieldErro>();
		for (FieldError fieldError : exception.getErrors().getFieldErrors()) {
			list.add(new FieldErro(fieldError.getField(), fieldError.getDefaultMessage()));
		}

		return new ResponseEntity<List<FieldErro>>(list, HttpStatus.PRECONDITION_FAILED);

	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<List<FieldErro>> validationPropertyException(BindException exception) {
		List<FieldErro> list = new ArrayList<FieldErro>();
		for (FieldError fieldError : exception.getFieldErrors()) {
			list.add(new FieldErro(fieldError.getField(), fieldError.getDefaultMessage()));
		}

		return new ResponseEntity<List<FieldErro>>(list, HttpStatus.PRECONDITION_FAILED);

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> resourceNotFound(ResourceNotFoundException exception) {
		return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

}
