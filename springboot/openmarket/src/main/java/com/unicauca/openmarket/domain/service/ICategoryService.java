package com.unicauca.openmarket.domain.service;
import com.unicauca.openmarket.domain.entity.Category;
import java.util.List;
public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long id);
    public Category create(Category category);
    public Category update(Long id, Category category);
    public void delete(Long id);
}