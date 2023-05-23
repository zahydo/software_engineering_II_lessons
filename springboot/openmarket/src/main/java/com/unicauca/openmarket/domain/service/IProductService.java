package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.domain.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product find(Long id);
    public Product create(Product id);
    public Product update(Long id,Product product);
    public void delete (Long id);
}
