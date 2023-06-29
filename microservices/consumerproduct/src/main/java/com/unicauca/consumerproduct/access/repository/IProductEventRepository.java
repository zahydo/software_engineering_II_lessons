package com.unicauca.consumerproduct.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.consumerproduct.domain.entity.ProductEvent;

public interface IProductEventRepository extends CrudRepository<ProductEvent, Long> {

}
