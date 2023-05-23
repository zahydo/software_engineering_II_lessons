package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.access.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    @Transactional(readOnly=true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional
    public Product find(Long id) {
        return repository.findById(id).orElse(null);
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
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
