package com.sahydo.openmarketapp.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketRequestError;
import com.sahydo.openmarketapp.utilities.EmailTemplateUtil;

@Service
public class EmailImplService implements IEmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendSimpleEmail(final String to, final String subject, final String body) {
		if (EmailTemplateUtil.IS_ENABLED_EMAILING) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("noreply@bogus.com");
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			emailSender.send(message);
			System.out.println("Correo enviado correctamente a " + to);
		}
	}

	@Override
	public void sendSimpleFailureEmail(String to, String subject, List<OpenmarketRequestError> errors) {
		sendSimpleEmail(to, subject, getErrorMessageFromOpenmarketErrors(errors));
	}

	private String getErrorMessageFromOpenmarketErrors(List<OpenmarketRequestError> errors) {
		String message = "The Openmarket Request was not processed due to the next problems: \n";
		List<String> errorMessages = errors.stream().map(error -> "\n" + error.message.concat(" "))
				.collect(Collectors.toList());
		return message.concat(String.join(" ", errorMessages));
	}

}
