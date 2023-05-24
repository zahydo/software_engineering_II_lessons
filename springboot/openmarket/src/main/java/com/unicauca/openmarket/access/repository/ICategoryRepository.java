
/**
 * 
 */
package com.unicauca.openmarket.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarket.domain.entity.Category;

public interface ICategoryRepository extends CrudRepository< Category, Long> {
    
}
