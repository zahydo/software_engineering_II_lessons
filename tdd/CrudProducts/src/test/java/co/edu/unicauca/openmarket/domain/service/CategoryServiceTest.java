/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.CategoryRepository;
import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoryServiceTest {
    
    public CategoryServiceTest() {
    }

    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");
        String name = "algo";
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        boolean expResult = true;
        boolean result = instance.saveCategory(name);
        if (result == expResult){
            assertEquals(expResult, result);
        } else{
            fail("The test case not aprovate.");
        }
    }

    @Test
    public void testFindAllCategories() {
        System.out.println("findAllCategories");
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        List<Category> expResult = new ArrayList<>();
        List<Category> result = instance.findAllCategories();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testFindCategoryById() {
        System.out.println("findCategoryById");
        Long id = 1L;
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        Category expResult = null;
        Category result = instance.findCategoryById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindCategoryByName() {
        System.out.println("findCategoryByName");
        String name = "";
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        List<Category> expResult = new ArrayList<>();
        List<Category> result = instance.findCategoryByName(name);
        assertEquals(expResult.size(), result.size());
    }

    @Test
    public void testDeleteCategoy() {
        System.out.println("deleteCategory");
        Long id = 0L;
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        boolean expResult = false;
        boolean result = instance.deleteCategoy(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditCategory() {
        System.out.println("editCategory");
        Long productId = null;
        Category category = null;
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        CategoryService instance = new CategoryService(categoryRep);
        boolean expResult = false;
        boolean result = instance.editCategory(productId, category);
        assertEquals(expResult, result);
    }
    
}