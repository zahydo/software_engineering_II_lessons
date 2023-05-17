package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryArrayService {

    private List<Category> categorys;

    public CategoryArrayService() {
        this.categorys = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categorys;
    }

    public void setCategories(List<Category> categories) {
        this.categorys = categories;
    }

    public Category upsertCategory(Category category, boolean createNewOne) {
        Category categor = null;
        for (Category c : categorys) {
            if (category.getCategoryId() != null &&
                    c.getCategoryId().equals(category.getCategoryId())) {
                c.setCategoryId(category.getCategoryId());
                c.setName(category.getName());

                categor = c;
                break;
            }
        }

        if (categor == null && createNewOne) {
            category.setCategoryId((long) (categorys.size() + 1));
            categorys.add(0, category);
            categor = category;
        }
        return categor;
    }

    public boolean deleteCategory(Long id) {
        for (Category c : categorys) {
            if (c.getCategoryId().equals(id)) {
                categorys.remove(c);
                return true;
            }
        }

        return false;
    }

    public Category findCategoryById(long id) {
        for (Category c : categorys) {
            if (c.getCategoryId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public List<Category> findCategoryByName(String name) {
        List<Category> categoriesByName = new ArrayList<>();
        for (Category c : categorys) {
            if (c.getName().equals(name)) {
                categoriesByName.add(c);
            }
        }

        return categoriesByName;
    }

}