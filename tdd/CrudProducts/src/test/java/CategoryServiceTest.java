import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;

public class CategoryServiceTest {

    private CategoryService service;
    private IcategoryRepository repository;
  
    
    
  
  
    public CategoryServiceTest() {
      repository = new MockCategoryRepository();
      service = new CategoryService(repository);
    }
  
    @Test
    public void testSaveProduct() {
      boolean result =
        this.service.saveCategory(3L,"This is a test Category");
      assertTrue(result);
    }
  
    @Test
    public void testSaveProductInvalidName() {
      boolean result =
        this.service.saveCategory(4l, "");
      assertFalse(result);
    }
  
    @Test
    public void testFindAllProducts() {
      List<Category> categories = this.service.findAllCategory();
      assertEquals(2, categories.size());
    }
  
    @Test
    public void testFindProductById() {
    Category categorie = this.service.findCategoryById(1L);
      assertNotNull(categorie);
      assertEquals(1L, categorie.getCategoryId().longValue());
    }
  
    @Test
    public void testFindProductByIdNotFound() {
       Category categorie = this.service.findCategoryById(10L);
      assertNull(categorie);
    }
  
    @Test
    public void testDeleteProduct() {
      boolean result = this.service.deleteCategory(1L);
      assertTrue(result);
    }
  
    @Test
    public void testDeleteProductNotFound() {
      boolean result = this.service.deleteCategory(10L);
      assertFalse(result);
    }
  
    @Test
    public void testEditProduct() {
      Category categoria1 = new Category();
      categoria1.setCategoryId(3L);
      categoria1.setName("Category 3");
      boolean result = this.service.editCategory(2L, categoria1);
      assertTrue(result);
    }
  
    @Test
    public void testEditProductNotFound() {
      Category categoria1 = new Category();
      categoria1.setCategoryId(3L);
      categoria1.setName("Category 3");
      boolean result = this.service.editCategory(3l, categoria1);
      assertFalse(result);
    }
  
    @Test
    public void testFindBynameAssert(){
      List<Category> categories = new ArrayList<>();
      categories = this.service.findCategoryByName("Category 1");
      assertEquals(1L, categories.get(0).getCategoryId().longValue());
    }
  
    @Test
    public void testFindBynameNotFound(){
      List<Category> categories = new ArrayList<>();
      categories = this.service.findCategoryByName("Category 4");
      assertEquals(0, categories.size());
    }
  
  



    private class MockCategoryRepository implements IcategoryRepository{

        List<Category> categories;

        public MockCategoryRepository(){
            this.categories = new ArrayList<Category>();
            Category categoria1 = new Category();
            categoria1.setCategoryId(1L);
            categoria1.setName("Category 1");
            Category categoria2 = new Category();
            categoria2.setCategoryId(2L);
            categoria2.setName("Category 2");
             this.categories.add(categoria1);
             this.categories.add(categoria2);
        
        }
    
        @Override
        public boolean save(Category newCategory){
            this.categories.add(newCategory);
            return true;
        }
    
        @Override
        public boolean edit(Long id, Category editCategory){
            boolean bandera = false;
            for (Category category : categories) {
                if(category.getCategoryId().equals(id)){
                    category = editCategory;
                    bandera = true;
                    break;
                }
            }

            return bandera;
        }
        
        @Override
        public boolean delete(Long id){
            boolean bandera = false;
            for (Category category : categories) {
                if(category.getCategoryId().equals(id)){
                categories.remove(category);
                bandera = true;
                break;
            }
        }

        return bandera;
        }
    
        @Override
        public Category findById(Long id){
            for (Category category : categories) {
                if(category.getCategoryId().equals(id)){
                    return category;
                }
                
            }

            return null;
        }
    
        @Override
        public List<Category> findByName(String name){
            List<Category> categorias = new ArrayList<>();
    for (Category category : categories) {
      if (category.getName().equals(name)) {
        categorias.add(category);
      }
    }
    return categorias;
        }
    
        @Override
        public List<Category> findAll(){
            return this.categories;
    
        }
    
    }
    
}


