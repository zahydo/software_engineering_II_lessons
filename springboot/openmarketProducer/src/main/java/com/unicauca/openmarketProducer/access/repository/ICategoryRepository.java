package com.unicauca.openmarketProducer.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketProducer.domain.entity.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
