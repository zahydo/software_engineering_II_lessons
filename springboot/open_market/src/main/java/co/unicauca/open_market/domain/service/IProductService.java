package co.unicauca.open_market.domain.service;

import java.util.List;

import co.unicauca.open_market.domain.entity.Product;

public interface IProductService {
    public List<Product> findAll();
    public Product find(Long id);
    public Product create(Product product);
    public Product update(Long id,Product product);
    public Product delete(Long id);
}
