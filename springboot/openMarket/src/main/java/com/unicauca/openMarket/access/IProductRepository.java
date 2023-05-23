package com.unicauca.openMarket.access;

import org.springframework.data.repository.CrudRepository;
import com.unicauca.openMarket.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {
    
}
