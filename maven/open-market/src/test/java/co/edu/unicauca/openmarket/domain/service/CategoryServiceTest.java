package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CategoryServiceTest {

    private CategoryService service;
    private ICategoryRepository repository;

    public CategoryServiceTest() {
        repository = Factory.getInstance().getRepositoryCategory("adapter");
        service = new CategoryService(repository);
    }
    
    @BeforeEach
    public void clean(){
        for(Category category : repository.findAll()){
            repository.delete(category.getCategoryId());
        }
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
        this.service.saveCategory("Test Category1");
        this.service.saveCategory("Test Category2");
        List<Category> categories = this.service.findAllCategory();
        assertEquals(2, categories.size());
    }

    @Test
    @DisplayName("Buscar una categoria por id")
    public void testFindCategoryById() {
        this.service.saveCategory("Test Category");
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
        this.service.saveCategory("Test Category");
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
        this.service.saveCategory("Test Category");
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

}
