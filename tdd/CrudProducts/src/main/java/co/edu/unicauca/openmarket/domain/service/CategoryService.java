/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.IRepository;
import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author restr
 */
public class CategoryService {

    private  IcategoryRepository repository;

    public CategoryService(IcategoryRepository repository) {
        this.repository = repository;
    }

    public boolean saveCategory(Long id,String name) {

        Category newCategory = new Category();
        newCategory.setName(name);
        newCategory.setCategoryId(id);

        //Validate category
        if (newCategory.getName().isEmpty()) {
            return false;
        }

        return repository.save(newCategory);

    }

    public List<Category> findAllCategory() {
        List<Category> category = new ArrayList<>();
        category = repository.findAll();

        return category;
    }

    public Category findCategoryById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteCategory(Long id) {
        return repository.delete(id);
    }

    public boolean editCategory(Long categoryId, Category category) {

        //Validate category
        if (category == null || category.getName().isEmpty()) {
            return false;
        }
        return repository.edit(categoryId, category);
    }

    public List<Category> findCategoryByName(String name) {
        List<Category> category = new ArrayList<>();
        category = repository.findByName(name);

        return category;
    }
}
