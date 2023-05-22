package com.unicauca.openmarket.domain.service;

import java.util.List;

import com.unicauca.openmarket.domain.entity.Category;

public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long categoryId);
    public Category create(Category category);
    public Category update(Long categoryId, Category category);
    public void delete(Long categoryId);
}
