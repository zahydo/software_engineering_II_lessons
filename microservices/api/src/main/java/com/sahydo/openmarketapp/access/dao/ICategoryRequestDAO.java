package com.sahydo.openmarketapp.access.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahydo.openmarketapp.domain.model.CategoryEvent;

public interface ICategoryRequestDAO extends PagingAndSortingRepository<CategoryEvent, Long> {

}
