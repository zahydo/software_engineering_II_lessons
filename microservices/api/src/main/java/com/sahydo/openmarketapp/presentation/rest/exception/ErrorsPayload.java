package com.sahydo.openmarketapp.presentation.rest.exception;

import java.util.List;

public class ErrorsPayload {
	public final List<OpenmarketRequestError> errors;

	public ErrorsPayload(List<OpenmarketRequestError> applicationErrors) {
		this.errors = applicationErrors;
	}
}
