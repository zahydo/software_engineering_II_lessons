package com.sahydo.openmarketapp.domain.service;

import java.io.Serializable;
import java.util.List;

import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketErrorDomainException;
import com.sahydo.openmarketapp.presentation.rest.exception.ResourceNotFoundException;

public interface IServiceRequestService<T extends Serializable> {
	public List<T> findAll();

	public T findById(Long id) throws ResourceNotFoundException;

	public T create(T T) throws OpenmarketErrorDomainException;
}
