/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.openmarket.access.adapter;

import co.unicauca.openmarket.client.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brayan
 */
public class CategoryArrayService {
   private List<Category> categorias;
   
    public CategoryArrayService(){
        categorias=new ArrayList<>();
    }

    public List<Category> getCategory() {
        return categorias;
    }

    public void setCategory(List<Category> category) {
        this.categorias = category;
    }
    
  public Category upsertProduct(Category category, boolean createNewOne) {
   Category cat = null;
    for (Category c :categorias ) {
      if (
        category.getCategoryId() != null &&
        c.getCategoryId().equals(category.getCategoryId())
      ) {
        c.setName(category.getName());
      

        cat = c;
        break;
      }
    }
    if (cat == null && createNewOne) {
      category.setCategoryId((long) (categorias.size() + 1));
     categorias.add(category);
      cat = category;
    }
    return cat;
  }

  public boolean deleteCategory(Long id) {
    for (Category c : categorias) {
      if (c.getCategoryId().equals(id)) {
        categorias.remove(c);
        return true;
      }
    }
    return false;
  }

  public Category findCategoryById(Long id) {
    for (Category c : categorias) {
      if (c.getCategoryId().equals(id)) {
        return c;
      }
    }
    return null;
  }

  public List<Category> findCategoryByName(String name) {
    List<Category> categoryByName = new ArrayList<>();
    for (Category p : categorias) {
      if (p.getName().equals(name)) {
        categoryByName.add(p);
      }
    }
    return categoryByName;
  }
   public List<Category>  findByCategory(Long id) {
    List<Category> categoriasByCategory = new ArrayList<>();
    for (Category c : categorias) {
      if (c.getCategoryId()==id) {
        categoriasByCategory.add(c);
      }
    }
    return categoriasByCategory;
  }
    
}
