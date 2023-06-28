package com.sahydo.openmarketapp.presentation.rest.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sahydo.openmarketapp.domain.model.ProductEvent;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<ErrorsPayload> handleResourceNotFoundException(ResourceNotFoundException e) {
		List<OpenmarketRequestError> openmarketErrors = new ArrayList<>();
		openmarketErrors.add(
				new OpenmarketRequestError(EnumErrorCode.NOT_FOUND, ProductEvent.class.getSimpleName(),
						e.getMessage()));
		return new ResponseEntity<>(new ErrorsPayload(openmarketErrors), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OpenmarketErrorDomainException.class)
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<ErrorsPayload> handleOpenmarketErrorDomainException(OpenmarketErrorDomainException e) {
		return new ResponseEntity<>(new ErrorsPayload(e.errors), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<ErrorsPayload> handleConstrainViolationException(ConstraintViolationException error) {
		List<OpenmarketRequestError> openmarketErrors = new ArrayList<>();
		error.getConstraintViolations().stream().forEach(violation -> {
			openmarketErrors.add(new OpenmarketRequestError(EnumErrorCode.INVALID_FIELD,
					violation.getPropertyPath().toString(), violation.getMessage()));
		});
		return new ResponseEntity<>(new ErrorsPayload(openmarketErrors), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<ErrorsPayload> handleHttpMessageNotReadableException(HttpMessageNotReadableException error) {
		List<OpenmarketRequestError> openmarketErrors = new ArrayList<>();
		openmarketErrors.add(new OpenmarketRequestError(EnumErrorCode.INVALID_FIELD, ProductEvent.class.getSimpleName(),
				error.getMessage()));
		return new ResponseEntity<>(new ErrorsPayload(openmarketErrors), HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
