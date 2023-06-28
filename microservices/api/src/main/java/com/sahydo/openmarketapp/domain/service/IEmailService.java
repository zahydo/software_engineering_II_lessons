package com.sahydo.openmarketapp.domain.service;

import java.util.List;

import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketRequestError;

public interface IEmailService {
	public void sendSimpleEmail(String to, String subject, String body);

	public void sendSimpleFailureEmail(String to, String subject, List<OpenmarketRequestError> errors);
}
