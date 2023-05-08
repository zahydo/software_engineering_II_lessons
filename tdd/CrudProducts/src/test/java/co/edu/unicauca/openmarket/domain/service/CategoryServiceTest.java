/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RodAlejo
 */
public class CategoryServiceTest {
    
    private CategoryService service;
    private ICategoryRepository repository;
    
    public CategoryServiceTest() {
        repository = new MockCategoryRepository();
        service = new CategoryService(repository);
    }

    @Test
    public void testSaveCategory() {
        boolean result = this.service.saveCategory("Test Category");
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
        Category category = this.service.findCategoryById(10L);
        assertNull(category);
    }

    @Test
    public void testFindCategoryByName() {
        List<Category> categories = this.service.findCategoryByName("Category 2");
        assertNotNull(categories);
        assertEquals(2L, categories.get(0).getCategoryId().longValue());
    }

    @Test
    public void testDeleteCategoy() {
        boolean result = this.service.deleteCategoy(1L);
        assertTrue(result);
    }
    
    @Test
    public void testDeleteCategoryNotFound() {
      boolean result = this.service.deleteCategoy(10L);
      assertFalse(result);
    }

    @Test
    public void testEditCategory() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setName("Test Category Update");
        boolean result = this.service.editCategory(1L, category);
        assertTrue(result);
    }
    
    
    @Test
    public void testEditCategoryNotFound() {
      Category category = new Category();
      category.setCategoryId(10L);
      category.setName("Test Category Update");
      boolean result = this.service.editCategory(10L, category);
      assertFalse(result);
    }

    private static class MockCategoryRepository implements ICategoryRepository {
        
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
        public boolean edit(Long id, Category category) {
            Category categoryToUpdate = findById(id);
            if (categoryToUpdate != null) {
              categoryToUpdate.setName(category.getName());
              return true;
            }
            return false;
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
        public Category findById(Long id) {
            for (Category category : categories) {
                if (category.getCategoryId().equals(id)) {
                  return category;
                }
            }
            return null;
        }

        @Override
        public List<Category> findbyName(String name) {
            List<Category> listReturn = new ArrayList<>();
            for (Category category : categories) {
                if (category.getName().equals(name)) {
                  listReturn.add(category);
                }
            }
            
            return listReturn;
        }

        @Override
        public List<Category> findAll() {
            return categories;
        }
    }
    
}
