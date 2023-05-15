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
 * @author SANTIAGO
 */
public class CatAdapterRepository implements ICategoryRepository{
    
    CategoryArrayService categoryArrayService;
    
    public CatAdapterRepository(){
        this.categoryArrayService = new CategoryArrayService();
    }

    @Override
    public boolean save(Category category) {
        return this.categoryArrayService.upsertCategory(category, true)!= null;
    }

    @Override
    public boolean edit(Long id, Category category) {
        category.setCategoryId(id);
        return this.categoryArrayService.upsertCategory(category, false) != null;
    }

    @Override
    public boolean delete(Long id) {
        return this.categoryArrayService.delete(id);
    }

    @Override
    public Category findById(Long id) {
        return this.categoryArrayService.findById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return this.categoryArrayService.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryArrayService.findAll();
    }
    
}
