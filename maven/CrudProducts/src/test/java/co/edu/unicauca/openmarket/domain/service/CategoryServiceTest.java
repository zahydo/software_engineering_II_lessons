package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author restr
 */
public class CategoryServiceTest {

    private CategoryService service;
    private IcategoryRepository repository;

    public CategoryServiceTest() {
        repository = Factory.getInstance().getRepositoryCategory("adapter");
        service = new CategoryService(repository);
    }

    @BeforeEach
    public void clean() {
        for (Category c : repository.findAll()) {
            repository.delete(c.getCategoryId());
        }
    }

    @Test
    public void testSaveCategory() {
        boolean result = this.service.saveCategory("Test Category");
        assertTrue(result);
    }

    @Test
    public void testSaveCategoryInvalidName() {
        boolean result = this.service.saveCategory("");
        assertFalse(result);
    }

    @Test
    public void testFindAllCategorys() {
        this.service.saveCategory("Test Category");
        List<Category> categories = this.service.findAllCategory();
        assertEquals(1, categories.size());
    }

    @Test
    public void testFindCategoryById() {
        this.service.saveCategory("Test Category");
        Category firstCategory = this.service.findAllCategory().get(0);
        Category category = this.service.findCategoryById(firstCategory.getCategoryId());
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
        this.service.saveCategory("Test Category");
        Category firsCategory = this.service.findAllCategory().get(0);
        boolean result = this.service.deleteCategory(firsCategory.getCategoryId());
        assertTrue(result);
    }

    @Test
    public void testDeleteCategoryNotFound() {
        boolean result = this.service.deleteCategory(10L);
        assertFalse(result);
    }

    @Test
    public void testEditCategory() {
        this.service.saveCategory("Test Category");
        Category firsCategory = this.service.findAllCategory().get(0);
        Category category = new Category();
        category.setCategoryId(firsCategory.getCategoryId());
        category.setName("Test Category");
        boolean result = this.service.editCategory(firsCategory.getCategoryId(), category);
        assertTrue(result);
    }

    @Test
    public void testEditCategoryNotFound() {
        Category category = new Category();
        category.setCategoryId(10L);
        category.setName("Test Category");
        boolean result = this.service.editCategory(10L, category);
        assertFalse(result);
    }

}
