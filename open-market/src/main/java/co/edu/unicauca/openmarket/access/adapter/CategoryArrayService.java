package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryArrayService {

  private List<Category> categories;

  public CategoryArrayService() {
    this.categories = new ArrayList<>();
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> pCategories) {
    this.categories = pCategories;
  }

  public Category upsertCategory(Category category, boolean createNewOne) {
    Category categ = null;
    for (Category c : categories) {
      if (
        category.getCategoryId() != null &&
        c.getCategoryId().equals(category.getCategoryId())
      ) {
        c.setName(category.getName());

        categ = c;
        break;
      }
    }
    if (categ == null && createNewOne) {
      category.setCategoryId((long) (categories.size() + 1));
      categories.add(category);
      categ = category;
    }
    return categ;
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
    for (Category c : categories) {
      if (c.getCategoryId().equals(id)) {
        return c;
      }
    }
    return null;
  }

  public List<Category> findCategoryByName(String name) {
    List<Category> categoriesByName = new ArrayList<>();
    for (Category c : categories) {
      if (c.getName().equals(name)) {
        categoriesByName.add(c);
      }
    }
    return categoriesByName;
  }
}
