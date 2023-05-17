package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

public class CategoryAdapterRepository implements IcategoryRepository {

    private CategoryArrayService categoryArrayService;

    public CategoryAdapterRepository() {
        categoryArrayService = new CategoryArrayService();
    }

    @Override
    public boolean save(Category categoria) {
        return this.categoryArrayService.upsertCategory(categoria, true) != null;
    }

    @Override
    public boolean edit(Long id, Category categoria) {
        categoria.setCategoryId(id);
        return this.categoryArrayService.upsertCategory(categoria, false) != null;
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
        return this.categoryArrayService.getCategories();
    }

}