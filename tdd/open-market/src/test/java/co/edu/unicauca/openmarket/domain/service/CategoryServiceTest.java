package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CategoryServiceTest {

    private CategoryService service;
    private ICategoryRepository repository;

    public CategoryServiceTest() {
        repository = new MockCategoryRepository();
        service = new CategoryService(repository);
    }

    @Test
    @DisplayName("Guardar una categoria")
    public void testSaveCategory() {
        boolean result = this.service.saveCategory("Test Category");
        assertTrue(result);
    }

    @Test
    @DisplayName("Guardar una categoria con nombre invalido")
    public void testSaveCategoryInvalidName() {
        boolean result = this.service.saveCategory("");
        assertFalse(result);
    }

    @Test
    @DisplayName("Buscar todas las categorias")
    public void testFindAllCategories() {
        List<Category> categories = this.service.findAllCategory();
        assertEquals(2, categories.size());
    }

    @Test
    @DisplayName("Buscar una categoria por id")
    public void testFindCategoryById() {
        Category category = this.service.findCategoryById(1L);
        assertNotNull(category);
        assertEquals(1L, category.getCategoryId().longValue());
    }

    @Test
    @DisplayName("Buscar una categoria por id no encontrada")
    public void testFindCategoryByIdNotFound() {
        Category category = this.service.findCategoryById(10L);
        assertNull(category);
    }

    @Test
    @DisplayName("Borrar una categoria")
    public void testDeleteCategory() {
        boolean result = this.service.deleteCategory(1L);
        assertTrue(result);
    }

    @Test
    @DisplayName("Borrar una categoria por id no encontrada")
    public void testDeleteCategoryNotFound() {
        boolean result = this.service.deleteCategory(10L);
        assertFalse(result);
    }

    @Test
    @DisplayName("Editar una categoria")
    public void testEditCategory() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setName("Test Category");
        boolean result = this.service.editCategory(1L, category);
        assertTrue(result);
    }

    @Test
    @DisplayName("Editar una categoria por id no encontrada")
    public void testEditCategoryNotFound() {
        Category category = new Category();
        category.setCategoryId(10L);
        category.setName("Test Category");
        boolean result = this.service.editCategory(10L, category);
        assertFalse(result);
    }

    private class MockCategoryRepository implements ICategoryRepository {

        private List<Category> categories;

        public MockCategoryRepository() {
            categories = new ArrayList<>();
            Category category1 = new Category(1L, "Category 1");
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
            throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
                                                                           // choose Tools | Templates.
        }

    }
}
