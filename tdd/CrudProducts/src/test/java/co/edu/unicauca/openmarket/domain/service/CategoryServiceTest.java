/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jorge
 */
public class CategoryServiceTest {

    private CategoryService service;
    private ICategoryRepository repository;

  
     //@BeforeAll
  public void setUp() {
    List<Category> categories = repository.findAll();
    categories.forEach(category -> {
      repository.delete(category.getCategoryId());
    });
  }
  
    public CategoryServiceTest() {
        
          repository = new CategoryServiceTest.MockCategoryRepository();
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
      this.service.saveCategory( "");
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
    Category category = this.service.findCategoryById(10L);
    assertNull(category);
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
    category.setName("Test Category");
    boolean result = this.service.editCategory(1L, category);
    assertTrue(result);
  }

  @Test
  public void testEditProductNotFound() {
    Category category = new Category();
    category.setCategoryId(10L);
    category.setName("Test Product");
    boolean result = this.service.editCategory(10L, category);
    assertFalse(result);
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
        public boolean save(Category category) {
            categories.add(category);
            return true;
        }

        @Override
        public List<Category> findAll() {
            return categories;
        }

        @Override
        public Category findById(Long id) {
            for (Category category : categories) {
                if (category.getCategoryId().equals(id)) {
                    return category;
                }
            }
            return null;
        }

        @Override
        public boolean delete(Long id) {
            Category category = findById(id);
            if (category != null) {
                categories.remove(category);
                return true;
            }
            return false;
        }

        @Override
        public boolean edit(Long id, Category category) {
            Category categoryToUpdate = findById(id);
            if (categoryToUpdate != null) {
                categoryToUpdate.setName(category.getName());
                return true;
            }
            return false;
        }

        @Override
        public List<Category> findByName(String name) {
          List<Category>categorias=new ArrayList<>();
          for(Category cat:categories){
              if(cat.getName().equals(name)){
                  categorias.add(cat);
              }
          }
          return categorias;
        }
 /*
        @Override
        
       
        public boolean clearCategories() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/

      

    }

}
