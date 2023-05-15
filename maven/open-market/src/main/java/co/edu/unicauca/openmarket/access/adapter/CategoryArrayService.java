package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANTIAGO
 */
public class CategoryArrayService {

    private List<Category> categories;

    public CategoryArrayService() {
        this.categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category upsertCategory(Category category, boolean createNewOne) {
        Category cat = null;
        for (Category c: categories) {
            if (category.getCategoryId() != null
                    && c.getCategoryId().equals(category.getCategoryId())) {
                c.setName(category.getName());
                cat = c;
                break;
            }
        }
        if (cat == null && createNewOne) {
            category.setCategoryId((long) (categories.size() + 1));
            categories.add(category);
            cat = category;
        }
        return cat;
    }


    public List<Category> findAll() {
        return categories;
    }

    public Category findById(Long id) {
        for (Category category : categories) {
            if (category.getCategoryId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        Category category = findById(id);
        if (category != null) {
            categories.remove(category);
            return true;
        }
        return false;
    }

    public boolean edit(Long id, Category category) {
        Category categoryToUpdate = findById(id);
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(category.getName());
            return true;
        }
        return false;
    }

    public List<Category> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
        // choose Tools | Templates.
    }
}
