
package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.domain.entity.Product;
import java.util.List;

/**
 *
 * @author SANTIAGO
 */
public interface IProductService {
    public List<Product> findAll();
    public Product find(long id);
    public Product create(Product product);
    public Product update(long id, Product product);
    public void delete(long id);
}
