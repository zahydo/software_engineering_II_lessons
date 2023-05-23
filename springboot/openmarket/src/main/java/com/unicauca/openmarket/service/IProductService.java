/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.service;

import com.unicauca.openmarket.domain.entity.Product;
import java.util.List;

/**
 *
 * @author brayan
 */
public interface IProductService {
    public List<Product>findAll();
    public Product find(Long Id);
    public Product create(Product product);
    public Product update(Long id,Product product);
    public void delete(Long id);
}
