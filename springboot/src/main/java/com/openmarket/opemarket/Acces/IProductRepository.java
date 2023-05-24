package com.openmarket.opemarket.Acces;

import org.springframework.data.repository.CrudRepository;

import com.openmarket.opemarket.domain.model.Product;

public interface IProductRepository extends CrudRepository<Product,Long>{


    
}