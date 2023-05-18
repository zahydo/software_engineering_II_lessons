/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RodAlejo
 */
public class CategoryArrayService {
    private List<Category> categories;
    
    public CategoryArrayService(){
        categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    
    public Category upsertCategory(Category category, boolean createNewOne) {
        Category cate = null;
        for (Category c : categories) {
          if (
            category.getCategoryId()!= null &&
            c.getCategoryId().equals(category.getCategoryId())
          ) {
            c.setName(category.getName());

            cate = c;
            break;
          }
        }
        if (cate == null && createNewOne) {
          category.setCategoryId((long) (categories.size() + 1));
          categories.add(category);
          cate = category;
        }
        return cate;
    }
    
    
    public boolean deleteCategory(Long id) {
        for (Category c : categories) {
          if (c.getCategoryId().equals(id)) {
            categories.remove(c);
            return true;
          }
        }
        return false;
    }

    public Category  findCategoryById(Long id) {
        for (Category c : categories) {
          if (c.getCategoryId().equals(id)) {
            return c;
          }
        }
        return null;
    }

    public List<Category> findCategoriesByName(String name) {
        List<Category> categoriesByName = new ArrayList<>();
        for (Category c : categories) {
          if (c.getName().equals(name)) {
            categoriesByName.add(c);
          }
        }
        return categoriesByName;
    }
    
}
