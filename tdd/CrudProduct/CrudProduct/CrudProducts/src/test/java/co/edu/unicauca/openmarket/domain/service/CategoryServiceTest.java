package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
//Hecho por ruben y naren
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryServiceTest {

  private CategoryService service;
  private ICategoryRepository repository;

  @BeforeAll
  public void setUp() {
    List<Category> categories = repository.findAll();
    categories.forEach(category -> {
      repository.delete(category.getCategoryId());
    });
  }

  public CategoryServiceTest() {
    repository = new MockCategoryRepository();
    service = new CategoryService(repository);
  }

  @Test
  public void testSaveCategory() {
    boolean result =
      this.service.saveCategory("Test Product");
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
    List<Category> categorys = this.service.findAllCategories();
    assertEquals(2, categorys.size());
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
    category.setName("Test Product");
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
      category1.setName("category 1");

      Category category2 = new Category();
      category2.setCategoryId(2L);
      category2.setName("category 2");
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
    public Category findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  }
}