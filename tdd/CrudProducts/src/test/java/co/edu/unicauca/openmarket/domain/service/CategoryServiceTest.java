package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author restr
 */
public class CategoryServiceTest {

    private CategoryService service;
    private IcategoryRepository repository;

    public CategoryServiceTest() {
        repository = new MockCategoryRepository();
        service = new CategoryService(repository);
    }

    @Test
    public void testSaveCategory() {
        boolean result
                = this.service.saveCategory("Test Category");
        assertTrue(result);
    }

    @Test
    public void testSaveCategoryInvalidName() {
        boolean result
                = this.service.saveCategory("");
        assertFalse(result);
    }

    @Test
    public void testFindAllCategorys() {
        List<Category> categorys = this.service.findAllCategory();
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
        category.setName("Test Category");
        boolean result = this.service.editCategory(1L, category);
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

    private class MockCategoryRepository implements IcategoryRepository {

        private List<Category> categorys;

        public MockCategoryRepository() {
            categorys = new ArrayList<>();
            Category category1 = new Category();
            category1.setCategoryId(1L);
            category1.setName("Category 1");
            Category category2 = new Category();
            category2.setCategoryId(2L);
            category2.setName("Category 2");
            categorys.add(category1);
            categorys.add(category2);
        }

        @Override
        public boolean save(Category category) {
            categorys.add(category);
            return true;
        }

        @Override
        public List<Category> findAll() {
            return categorys;
        }

        @Override
        public Category findById(Long id) {
            for (Category category : categorys) {
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
                categorys.remove(category);
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
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
