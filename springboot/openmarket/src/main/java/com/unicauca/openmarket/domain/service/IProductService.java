package com.unicauca.openmarket.domain.service;

import java.util.List;

import com.unicauca.openmarket.domain.entity.Product;

public interface IProductService {
    public List<Product> findAll();
    public Product find(Long productId);
    public Product create(Product product);
    public Product update(Long productId, Product product);
    public void delete(Long productId);
}