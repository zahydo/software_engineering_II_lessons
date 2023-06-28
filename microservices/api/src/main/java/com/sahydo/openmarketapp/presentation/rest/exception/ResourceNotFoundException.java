package com.sahydo.openmarketapp.presentation.rest.exception;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long id;

	public ResourceNotFoundException(Long id) {
		super("There is no Resource with id: " + id);
	}

}
