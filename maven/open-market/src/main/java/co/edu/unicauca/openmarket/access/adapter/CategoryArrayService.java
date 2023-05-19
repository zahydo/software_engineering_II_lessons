package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;


public class CategoryArrayService {
  private List<Category> categories;

  public CategoryArrayService(){
      this.categories = new ArrayList<>();
  }

  public Category upsertCategory(Category category, boolean createNewOne) {
      Category cat = null;
      for (Category c : categories) {
        if (
          category.getCategoryId()!= null &&
          c.getCategoryId().equals(category.getCategoryId())
        ) {
          c.setName(category.getName());

          cat = c;
          break;
        }
      }
      if (cat == null && createNewOne) {
        category.setCategoryId((long) (categories.size() + 1));
        categories.add(category);
        cat = category;
      }
      return cat;
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

  public Category findCategoryById(Long id) {
      for (Category p : categories) {
        if (p.getCategoryId().equals(id)) {
          return p;
        }
      }
      return null;
  }

  public List<Category> findCategoryName(String name) {
      List<Category> categoriesName = new ArrayList<>();
      for (Category p : categories) {
        if (p.getName().equals(name)) {
          categoriesName.add(p);
        }
      }
      return categoriesName;
  }

  public List<Category> getCategories() {
      return categories;
  }

  public void setCategories(List<Category> pCategories) {
      this.categories = pCategories;
  }

}