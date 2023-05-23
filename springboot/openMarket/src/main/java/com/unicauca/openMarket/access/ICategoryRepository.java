package com.unicauca.openMarket.access;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openMarket.domain.entity.Category;;
/**
 * @author nimbachi
 */

public interface ICategoryRepository extends CrudRepository<Category, Long>{
    
}
