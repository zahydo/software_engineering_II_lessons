package com.sahydo.openmarketapp.presentation.rest.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenmarketRequestError {
	public final EnumErrorCode code;
	public final String field;
	public final String message;
}
