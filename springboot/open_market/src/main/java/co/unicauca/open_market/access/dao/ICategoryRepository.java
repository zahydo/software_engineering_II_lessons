package co.unicauca.open_market.access.dao;

import org.springframework.data.repository.CrudRepository;

import co.unicauca.open_market.domain.entity.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long>{
    
}
