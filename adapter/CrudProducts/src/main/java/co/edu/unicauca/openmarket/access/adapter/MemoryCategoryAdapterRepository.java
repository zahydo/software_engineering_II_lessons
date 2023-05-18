/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.unicauca.openmarket.client.domain.Category;
import java.util.List;

/**
 *
 * @author brayan
 */
public class MemoryCategoryAdapterRepository implements ICategoryRepository{
    private CategoryArrayService categoryArrayrepository;
     public MemoryCategoryAdapterRepository(){
         categoryArrayrepository=new CategoryArrayService();
     }
         
    @Override
    public boolean save(Category newCategory) {
      return  this.categoryArrayrepository.upsertProduct(newCategory, true)!=null;
    }

    @Override
    public boolean edit(Long id, Category category) {
        category.setCategoryId(id);
      return this.categoryArrayrepository.upsertProduct(category, true)!=null;
    }

    @Override
    public boolean delete(Long id) {
       return this.categoryArrayrepository.deleteCategory(id);
    }

    @Override
    public Category findById(Long id) {
       return  this.categoryArrayrepository.findCategoryById(id);
    }

    @Override
    public List<Category> findAll() {
       return this.categoryArrayrepository.getCategory();
    }

    @Override
    public List<Category> findByName(String name) {
       return this.categoryArrayrepository.findCategoryByName(name);
    }
    
}
