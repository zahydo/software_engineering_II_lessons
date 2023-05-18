package co.unicauca.open_market.domain.service;

import java.util.List;

import co.unicauca.open_market.domain.entity.Category;

public interface ICategoryService {
    public List<Category> findAll();
    public Category find(Long id);
    public Category create(Category category);
    public Category update(Long id,Category category);
    public Category delete(Long id);
}
