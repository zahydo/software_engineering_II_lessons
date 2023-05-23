package com.unicauca.openmarket.domain.service;

import java.util.List;

import com.unicauca.openmarket.domain.entity.Category;

public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long id);
    public Category create(Category category);
    public Category update(Long id, Category category);
    public void delete(Long id);  
    
}
