package com.sahydo.openmarketapp.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahydo.openmarketapp.access.dao.IProductRequestDAO;
import com.sahydo.openmarketapp.domain.model.ProductEvent;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketErrorDomainException;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketRequestError;
import com.sahydo.openmarketapp.presentation.rest.exception.EnumErrorCode;
import com.sahydo.openmarketapp.presentation.rest.exception.ResourceNotFoundException;
import com.sahydo.openmarketapp.utilities.EmailTemplateUtil;

@Service
public class ProductRequestImplService implements IProductEventService {

	@Autowired
	private IProductRequestDAO productRequestDAO;
	@Autowired
	private IEmailService emailService;

	@Override
	@Transactional(readOnly = true) // To sync with db
	public List<ProductEvent> findAll() {
		return (List<ProductEvent>) productRequestDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true) // To sync with db
	public ProductEvent findById(Long id) throws ResourceNotFoundException {
		ProductEvent openmarketRequest = productRequestDAO.findById(id).orElse(null);
		if (openmarketRequest == null) {
			throw new ResourceNotFoundException(id);
		}
		return openmarketRequest;
	}

	@Override
	@Transactional
	public ProductEvent create(ProductEvent openmarketRequest) throws OpenmarketErrorDomainException {
		List<OpenmarketRequestError> errors = validateOpenmarketRequest(openmarketRequest);
		if (!errors.isEmpty()) {
			throw new OpenmarketErrorDomainException(errors);
		}
		ProductEvent openmarketRequestSaved = productRequestDAO.save(openmarketRequest);
		if (openmarketRequestSaved != null) {
			emailService.sendSimpleEmail(openmarketRequest.getHolderEmail(),
					EmailTemplateUtil.OPENMARKET_SUCCESSFULLY_CREATED_SUBJECT,
					"The Openmarket request was created successfully. Please check the details below: \n"
							+ openmarketRequest.toString());
		}
		return openmarketRequestSaved;
	}

	private List<OpenmarketRequestError> validateOpenmarketRequest(final ProductEvent openmarketRequest) {
		List<OpenmarketRequestError> errors = new ArrayList<>();
		if (!openmarketRequest.getHolderEmail().contains("@")) {
			errors.add(new OpenmarketRequestError(EnumErrorCode.INVALID_FIELD, "Invalid email",
					"The email is invalid"));
		}
		return errors;
	}
}
