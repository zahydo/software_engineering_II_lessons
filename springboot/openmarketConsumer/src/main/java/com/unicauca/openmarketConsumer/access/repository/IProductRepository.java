package com.unicauca.openmarketConsumer.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketConsumer.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
