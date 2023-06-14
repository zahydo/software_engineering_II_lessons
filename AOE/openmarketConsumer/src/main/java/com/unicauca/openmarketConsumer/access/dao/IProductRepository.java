
package com.unicauca.openmarketConsumer.access.dao;

import com.unicauca.openmarketConsumer.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author brayan
 */
public interface  IProductRepository extends CrudRepository<Product,Long> {
    
}
