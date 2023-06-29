package com.unicauca.producercategory.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.producercategory.domain.entity.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
