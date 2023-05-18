package com.unicauca.openmarket.domain.service;

import java.util.List;

import com.unicauca.openmarket.domain.entity.Product;

public interface IProductService {
    public List<Product> findAll();

    public Product find(Long id);

    public Product create(Product product);

    public Product update(Long id, Product product);

    public void delete(long id);
}
