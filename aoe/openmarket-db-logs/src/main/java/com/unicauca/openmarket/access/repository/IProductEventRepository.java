package com.unicauca.openmarket.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarket.domain.entity.ProductEvent;

public interface IProductEventRepository extends CrudRepository<ProductEvent, Long> {

}
