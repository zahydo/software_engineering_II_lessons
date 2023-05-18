package co.unicauca.open_market.access.dao;

import org.springframework.data.repository.CrudRepository;

import co.unicauca.open_market.domain.entity.Product;



public interface IProductRepository extends CrudRepository<Product, Long>{
    
}
