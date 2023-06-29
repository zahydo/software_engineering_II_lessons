package com.unicauca.consumercategory.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.consumercategory.domain.entity.CategoryEvent;

public interface ICategoryEventRepository extends CrudRepository<CategoryEvent, Long> {

}
