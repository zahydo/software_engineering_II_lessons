package com.unicauca.openmarketProducer.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketProducer.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
