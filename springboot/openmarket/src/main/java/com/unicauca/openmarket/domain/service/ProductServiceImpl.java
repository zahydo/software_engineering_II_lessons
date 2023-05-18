package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarket.access.repository.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;

@Service // Indicates this class is a service
public class ProductServiceImpl implements IProductService {

    @Autowired // Injects an instance of IProductRepository into this service without the need
               // of a constructor
    private IProductRepository repository;

    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Product find(Long id) {
        Product prod = repository.findById(id).orElse(null);
        return prod;
    }

    @Override
    @Transactional
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Product update(Long id, Product product) {
        Product prod = this.find(id);
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

}
