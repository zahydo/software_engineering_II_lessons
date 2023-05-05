/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alejandro, William
 */
public class CategoryServiceTest {
    
    private CategoryService service;
    private ICategoryRepository repository;  
    
    @BeforeAll
  public void setUp() {
    List<Category> categories = repository.findAllC();
    categories.forEach(product -> {
      repository.deleteC(product.getCategoryId());
    });
  }
  
  public CategoryServiceTest() {
    repository = new MockCategoryRepository();
    service = new CategoryService(repository);
  }

  @Test
  public void testSaveCategory() {
    boolean result =
      this.service.saveCategory("Test Category");
    assertTrue(result);
  }

  @Test
  public void testSaveCategoryInvalidName() {
    boolean result =
      this.service.saveCategory("");
    assertFalse(result);
  }

  @Test
  public void testFindAllCategories() {
    List<Category> categories = this.service.findAllCategories();
    assertEquals(2, categories.size());
  }

  @Test
  public void testFindCategoryById() {
    Category category = this.service.findCategoryById(1L);
    assertNotNull(category);
    assertEquals(1L, category.getCategoryId().longValue());
  }

  @Test
  public void testFindCategoryByIdNotFound() {
    Category product = this.service.findCategoryById(10L);
    assertNull(product);
  }

  @Test
  public void testDeleteCategory() {
    boolean result = this.service.deleteCategory(1L);
    assertTrue(result);
  }

  @Test
  public void testDeleteCategoryNotFound() {
    boolean result = this.service.deleteCategory(10L);
    assertFalse(result);
  }

  @Test
  public void testEditCategory() {
    Category category = new Category();
    category.setCategoryId(1L);
    category.setName("Test edit Product");
    boolean result = this.service.editCategory(1L, category);
    assertFalse(result);
  }

  @Test
  public void testEditCategoryNotFound() {
    Category category = new Category();
    category.setCategoryId(10L);
    category.setName("Test Product");
    boolean result = this.service.editCategory(10L, category);
    assertFalse(result);
  }
  
  @Test
  public void testFindCategoryByName(){
    Category category = this.service.findCategoryByName("Category 2");
    assertNotNull(category);
    assertEquals("Category 2", category.getName());
  }
  
  @Test
  public void testFindCategoryByNameNotFound(){
    Category category = this.service.findCategoryByName("Category 3");
    assertNull(category);
  }

  private class MockCategoryRepository implements ICategoryRepository {

    private List<Category> categories;

    public MockCategoryRepository() {
      categories = new ArrayList<>();
      Category category1 = new Category();
      category1.setCategoryId(1L);
      category1.setName("Category 1");
      Category category2 = new Category();
      category2.setCategoryId(2L);
      category2.setName("Category 2");
      categories.add(category1);
      categories.add(category2);
    }

    @Override
    public boolean saveC(Category newCategory) {
      categories.add(newCategory);
      return true;
    }

    @Override
    public List<Category> findAllC() {
      return categories;
    }

    @Override
    public Category findByIdC(Long id) {
      for (Category category : categories) {
        if (category.getCategoryId().equals(id)) {
          return category;
        }
      }
      return null;
    }

    @Override
    public boolean deleteC(Long id) {
      Category category = findByIdC(id);
      if (category != null) {
        categories.remove(category);
        return true;
      }
      return false;
    }

    @Override
    public boolean editC(Long id, Category category) {
        for(int i=0; i < this.categories.size(); i++){
            if(this.categories.get(i).getCategoryId()== id){
                this.categories.set(i, category);
                return true;
            }
        }
        return false;
    }

    @Override
    public Category findByNameC(String name) {
        for(Category category: categories){
            if(category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }
  }
    
}
