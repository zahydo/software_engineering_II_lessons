/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

/**
 *
 * @author RodAlejo
 */
public class MemoryAdapterCategoryRepository implements ICategoryRepository{
    
    private CategoryArrayService service;
    
    public MemoryAdapterCategoryRepository(){
        service = new CategoryArrayService();
    }

    @Override
    public boolean save(Category category) {
        
        return this.service.upsertCategory(category, true) != null;
    }

    @Override
    public boolean edit(Long id, Category category) {
        category.setCategoryId(id);
        return this.service.upsertCategory(category, false) != null;
    }

    @Override
    public boolean delete(Long id) {
        return this.service.deleteCategory(id);
    }

    @Override
    public Category findById(Long id) {
        return this.service.findCategoryById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return this.service.findCategoriesByName(name);
    }

    @Override
    public List<Category> findAll() {
        return this.service.getCategories();
    }
    
}
