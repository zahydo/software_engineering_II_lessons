package com.unicauca.openmarket.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarket.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {
    
}
