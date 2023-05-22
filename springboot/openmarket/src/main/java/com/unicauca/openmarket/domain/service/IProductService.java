package com.unicauca.openmarket.domain.service;

import java.util.List;

import com.unicauca.openmarket.domain.entity.Product;

public interface IProductService {
    public List<Product> findAll();
    public Product find(Long id);
    public Product create(Product producto);
    public Product update(Long id, Product producto);
    public void delete(Long id);
}
