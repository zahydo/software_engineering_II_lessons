package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
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

  public Category upsertCategory(Category prmCategory, boolean createNewOne) {
    Category objAuxCategory = null;
    for (Category category : categories) {
      if (prmCategory.getCategoryId() != null && category.getCategoryId().equals(prmCategory.getCategoryId())){
        category.setName(prmCategory.getName());
        objAuxCategory = category;
        break;
      }
    }
    if (objAuxCategory == null && createNewOne) {
      prmCategory.setCategoryId((long) (categories.size() + 1));
      categories.add(prmCategory);
      objAuxCategory = prmCategory;
    }
    return objAuxCategory;
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
