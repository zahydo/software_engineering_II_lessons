package com.unicauca.openmarket.access.dao;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarket.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {
    
}