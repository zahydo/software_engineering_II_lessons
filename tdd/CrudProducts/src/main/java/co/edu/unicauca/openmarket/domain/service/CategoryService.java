
package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author brayan
 */
public class CategoryService {
    
    
    public CategoryService(){
        
    }
    private ICategoryRepository repository;
    
    public CategoryService(ICategoryRepository repository){
        this.repository=repository;
    }
    public boolean saveCategory (String name){
        Category newCategory=new Category();
        newCategory.setName(name);
        if(newCategory.getName().isBlank()){
            return false;
        }
        return repository.save(newCategory);
    }
    public boolean editCategory(Long categoryId,Category cat) {
        
        //Validate product
        if(cat==null || cat.getName().isBlank()){
            return false;
        }
      
       
        return repository.edit(categoryId,cat);
    }
    
   public boolean deleteCategory(Long id){
        return repository.delete(id);
    }  
    public Category findCategoryById(Long id){
        return repository.findById(id);
    }
       public List<Category> findAllCategories(){
        return repository.findAll();
    }
       
       public List<Category> findCategoriesByName(String name){
        return repository.findByName(name);
    }
       /*
       public boolean clearCategories(){
           return repository.clearCategories();
       }*/
}  
        
