package com.unicauca.openMarket.domain.service;

import java.util.List;

import com.unicauca.openMarket.domain.entity.Category;

/**
 * @author nimbachi
 */

public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long id);
    public Category create(Category category);
    public Category update(Long id, Category category);
    public void delete(Long id);
}
