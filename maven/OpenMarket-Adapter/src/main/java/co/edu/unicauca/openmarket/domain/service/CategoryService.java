package co.edu.unicauca.openmarket.domain.service;


import java.util.ArrayList;
import java.util.List;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;

/**
 *
 * @author Libardo, Julio
 */
public class CategoryService {

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private ICategoryRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de ICategoryRepository
     */
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }


    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        //Validate category
        if (newCategory.getName().isEmpty()) {
            return false;
        }

        return repository.save(newCategory);

    }

    public List<Category> findAllCategorys() {
        List<Category> categorys = new ArrayList<>();
        categorys = repository.findAll();

        return categorys;
    }
    
    public Category findCategoryById(Long id){
        return repository.findById(id);
    }
    
    public boolean deleteCategory(Long id){
        return repository.delete(id);
    }

    public boolean editCategory(Long categoryId, Category cat) {
        
        //Validate category
        if (cat == null || cat.getName().isEmpty()) {
            return false;
        }
        return repository.edit(categoryId, cat);
    }

}

