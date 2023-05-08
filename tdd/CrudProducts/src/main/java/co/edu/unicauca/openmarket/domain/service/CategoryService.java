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
 * @author RodAlejo
 */
public class CategoryService {
    
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private ICategoryRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de ICategoryRepository
     */
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }


    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        //Validate product
        if (newCategory.getName().isEmpty()) {
            return false;
        }

        return repository.save(newCategory);

    }

    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories = repository.findAll();;

        return categories;
    }
    
    public Category findCategoryById(Long id){
        return repository.findById(id);
    }
    
    public List<Category> findCategoryByName(String name){
        return repository.findbyName(name);
    }
    
    public boolean deleteCategoy(Long id){
        return repository.delete(id);
    }
    
    

    public boolean editCategory(Long productId, Category category) {
        
        //Validate product
        if (category == null || category.getName().isEmpty() ) {
            return false;
        }
        return repository.edit(productId, category);
    }
}
