package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;


public class MemoryAdapterRepositoryC implements ICategoryRepository{

    private CategoryArrayService categoryArrayService;

    public MemoryAdapterRepositoryC() {
        this.categoryArrayService = new CategoryArrayService();
    }
    
    @Override
    public boolean save(Category category) {
        return this.categoryArrayService.upserCategory(category, true) != null;
    }

    @Override
    public boolean edit(Long id, Category category) {
        category.setCategoryId(id);
        return this.categoryArrayService.upserCategory(category, false) != null;
    }

    @Override
    public boolean delete(Long id) {
        return this.categoryArrayService.deleteCategory(id);
    }

    @Override
    public Category findById(Long id) {
        return this.categoryArrayService.findCategoryById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return this.categoryArrayService.findCategoryByName(name);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryArrayService.getCategorias();
    }
    
}
