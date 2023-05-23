
package com.unicauca.openmarket.service;

import com.unicauca.openmarket.domain.entity.Category;
import java.util.List;

/**
 *
 * @author brayan
 */
public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long categoryId);
    public Category create(Category category);
    public Category update(Long categoryId, Category category);
    public void delete(Long categoryId);
}
