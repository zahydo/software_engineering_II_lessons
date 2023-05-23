package com.unicauca.openMarket.domain.service;

import com.unicauca.openMarket.access.IProductRepository;
import com.unicauca.openMarket.domain.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 

public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository repository; 

    @Transactional(readOnly =  true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Product find(Long id) {
        Product prod = repository.findById(id).orElse(null);
        return prod;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product prod = this.find(id);
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}