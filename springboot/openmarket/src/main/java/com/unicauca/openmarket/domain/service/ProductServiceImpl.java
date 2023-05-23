package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.repository.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{
    
    @Autowired
    private IProductRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return (List<Product>) repository.findAll();
    }
    @Override
    public Product find(Long id){
        Product prod = repository.findById(id).orElse(null);
        return prod;
    }
    @Override
    @Transactional
    public Product create(Product product){
        return repository.save(product);
    }
    @Override
    @Transactional
    public Product update(Long id, Product product){
        Product prod = this.find(id);
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }
    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
}
