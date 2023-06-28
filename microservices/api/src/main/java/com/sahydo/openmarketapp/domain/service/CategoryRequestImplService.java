package com.sahydo.openmarketapp.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahydo.openmarketapp.access.dao.ICategoryRequestDAO;
import com.sahydo.openmarketapp.domain.model.CategoryEvent;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketErrorDomainException;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketRequestError;
import com.sahydo.openmarketapp.presentation.rest.exception.EnumErrorCode;
import com.sahydo.openmarketapp.presentation.rest.exception.ResourceNotFoundException;
import com.sahydo.openmarketapp.utilities.EmailTemplateUtil;

@Service
public class CategoryRequestImplService implements ICategoryEventService {

	@Autowired
	private ICategoryRequestDAO categoryRequestDAO;
	@Autowired
	private IEmailService emailService;

	@Override
	@Transactional(readOnly = true) // To sync with db
	public List<CategoryEvent> findAll() {
		return (List<CategoryEvent>) categoryRequestDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true) // To sync with db
	public CategoryEvent findById(Long id) throws ResourceNotFoundException {
		CategoryEvent openmarketRequest = categoryRequestDAO.findById(id).orElse(null);
		if (openmarketRequest == null) {
			throw new ResourceNotFoundException(id);
		}
		return openmarketRequest;
	}

	@Override
	@Transactional
	public CategoryEvent create(CategoryEvent openmarketRequest) throws OpenmarketErrorDomainException {
		List<OpenmarketRequestError> errors = validateOpenmarketRequest(openmarketRequest);
		if (!errors.isEmpty()) {
			throw new OpenmarketErrorDomainException(errors);
		}
		CategoryEvent openmarketRequestSaved = categoryRequestDAO.save(openmarketRequest);
		if (openmarketRequestSaved != null) {
			emailService.sendSimpleEmail(openmarketRequest.getHolderEmail(),
					EmailTemplateUtil.OPENMARKET_SUCCESSFULLY_CREATED_SUBJECT,
					"The Openmarket request was created successfully. Please check the details below: \n"
							+ openmarketRequest.toString());
		}
		return openmarketRequestSaved;
	}

	private List<OpenmarketRequestError> validateOpenmarketRequest(final CategoryEvent openmarketRequest) {
		List<OpenmarketRequestError> errors = new ArrayList<>();
		if (!openmarketRequest.getHolderEmail().contains("@")) {
			errors.add(new OpenmarketRequestError(EnumErrorCode.INVALID_FIELD, "Invalid email",
					"The email is invalid"));
		}
		return errors;
	}
}
