package com.unicauca.producerproduct.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.producerproduct.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
