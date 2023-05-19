package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

public class MemoryAdapterCategoryRepository implements ICategoryRepository {

  private CategoryArrayService categoryArrayservice;


  public MemoryAdapterCategoryRepository() {
    categoryArrayservice = new CategoryArrayService();
  }

  @Override
  public boolean save(Category categorie) {
    return this.categoryArrayservice.upsertCategory(categorie, true) != null;
  }

  @Override
  public boolean edit(Long id, Category categorie) {
    categorie.setCategoryId(id);
    return this.categoryArrayservice.upsertCategory(categorie, false) != null;
  }

  @Override
  public boolean delete(Long id) {
    return this.categoryArrayservice.deleteCategory(id);
  }

  @Override
  public Category findById(Long id) {
    return this.categoryArrayservice.findCategoryById(id);
  }

  @Override
  public List<Category> findByName(String name) {
    return this.categoryArrayservice.findCategoryName(name);
  }

  @Override
  public List<Category> findAll() {
    return this.categoryArrayservice.getCategories();
  }
}