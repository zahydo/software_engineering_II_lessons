package com.sahydo.openmarketapp.presentation.rest.exception;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenmarketErrorDomainException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final List<OpenmarketRequestError> errors;

}
