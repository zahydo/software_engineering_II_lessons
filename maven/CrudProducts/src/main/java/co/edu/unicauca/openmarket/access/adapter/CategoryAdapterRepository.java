package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.IcategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

public class CategoryAdapterRepository implements IcategoryRepository{

    private CategoryArrayService categoryArrayService;

    public CategoryAdapterRepository(){
        categoryArrayService = new CategoryArrayService();
    }

	@Override
	public boolean save(Category object) {
		// TODO Auto-generated method stub
        return this.categoryArrayService.upsertCategory(object, true) != null;
	}

	@Override
	public boolean edit(Long id, Category object) {
		// TODO Auto-generated method stub
		object.setCategoryId(id);
        return this.categoryArrayService.upsertCategory(object, false) != null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return this.categoryArrayService.deleteCategory(id);
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return this.categoryArrayService.findCategorybyId(id);
	}

	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return this.categoryArrayService.findCategoryByname(name);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return this.categoryArrayService.getCategories();
	}
    
}
