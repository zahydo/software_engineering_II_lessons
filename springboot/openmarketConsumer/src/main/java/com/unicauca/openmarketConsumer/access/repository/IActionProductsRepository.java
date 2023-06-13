package com.unicauca.openmarketConsumer.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;

public interface IActionProductsRepository extends CrudRepository<ActionProducts, Long> {
    
}
