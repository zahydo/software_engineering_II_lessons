package com.openmarket.opemarket.Acces;

import org.springframework.data.repository.CrudRepository;

import com.openmarket.opemarket.domain.model.Category;

public interface ICategoryRepository extends CrudRepository<Category,Long>{
    
}

