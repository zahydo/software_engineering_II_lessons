package com.unicauca.openmarketConsumer.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketConsumer.domain.entity.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
