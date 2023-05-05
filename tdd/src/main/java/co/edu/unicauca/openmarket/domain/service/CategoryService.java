/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william
 */
public class CategoryService {
    
    private ICategoryRepository repository;
    
    public CategoryService(ICategoryRepository repository){
        this.repository = repository;
    }

    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        //Validate product
        if (newCategory.getName().isBlank() ) {
            return false;
        }

        return repository.saveC(newCategory);

    }

    public List<Category> findAllCategories() {
        List<Category> category = new ArrayList<>();
        category = repository.findAllC();

        return category;
    }
    
    public Category findCategoryById(Long categoryId){
        return repository.findByIdC(categoryId);
    }
    
    public Category findCategoryByName(String categoryName){
        return repository.findByNameC(categoryName);
    }
    
    public boolean deleteCategory(Long categoryId){
        return repository.deleteC(categoryId);
    }

    public boolean editCategory(Long categoryId, Category category) {
        
        //Validate product
        if (category == null || category.getName().isBlank() ) {
            return false;
        }
        return repository.editC(categoryId, category);
    }
    
    
}
