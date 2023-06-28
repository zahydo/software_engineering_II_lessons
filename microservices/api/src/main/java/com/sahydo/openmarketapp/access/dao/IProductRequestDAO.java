package com.sahydo.openmarketapp.access.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sahydo.openmarketapp.domain.model.ProductEvent;

public interface IProductRequestDAO extends PagingAndSortingRepository<ProductEvent, Long> {

}
