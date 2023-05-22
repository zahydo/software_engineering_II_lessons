
package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.domain.entity.Category;
import java.util.List;

/**
 *
 * @author SANTIAGO
 */
public interface ICategoryService {
    public List<Category> findAll();
    public Category find(long id);
    public Category create(Category category);
    public Category update(long id, Category category);
    public void delete(long id);
}
