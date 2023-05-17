package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryArrayService {

  private List<Category> categorys;

  public CategoryArrayService() {
    this.categorys = new ArrayList<>();
  }

  public List<Category> getCategorys() {
    return categorys;
  }

  public void setCategorys(List<Category> categorys) {
    this.categorys = categorys;
  }

  public Category upsertCategory(Category category, boolean createNewOne) {
    Category cat = null;
    for (Category c : categorys) {
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
      category.setCategoryId((long) (categorys.size() + 1));
      categorys.add(category);
      cat = category;
    }
    return cat;
  }

  public boolean deleteCategory(Long id) {
    for (Category c : categorys) {
      if (c.getCategoryId().equals(id)) {
        categorys.remove(c);
        return true;
      }
    }
    return false;
  }

  public Category findCategoryById(Long id) {
    for (Category c : categorys) {
      if (c.getCategoryId().equals(id)) {
        return c;
      }
    }
    return null;
  }

  public List<Category> findCategoryByName(String name) {
    List<Category> categorysByName = new ArrayList<>();
    for (Category c : categorys) {
      if (c.getName().equals(name)) {
        categorysByName.add(c);
      }
    }
    return categorysByName;
  }
}

