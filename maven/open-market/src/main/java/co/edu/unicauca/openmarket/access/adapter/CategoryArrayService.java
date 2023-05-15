package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;


public class CategoryArrayService {
    private List<Category> categorias;

    public CategoryArrayService() {
        this.categorias = new ArrayList<>();
    }

    public List<Category> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Category> categorias) {
        this.categorias = categorias;
    }
    
    public Category upserCategory(Category category, boolean createNewOne){
        Category cat = null;
        for(Category c : categorias){
            if(
                category.getCategoryId() != null && 
                c.getCategoryId().equals(category.getCategoryId()))
            {
                c.setName(category.getName());
                
                cat = c;
                break;
            }
        }
        
        if(cat == null && createNewOne){
            category.setCategoryId((long) (categorias.size() + 1));
            categorias.add(category);
            cat = category;
        }
        return cat;
    }
    
    public boolean deleteCategory(Long id){
        for(Category c : categorias){
            if(c.getCategoryId().equals(id)){
                categorias.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public Category findCategoryById(Long id){
        for(Category c : categorias){
            if(c.getCategoryId().equals(id)){
                return c;
            }
        }
        return null;
    }
    
    public List<Category> findCategoryByName(String name){
        List<Category> categoriesByName = new ArrayList<>();
        for(Category c : categorias){
            if(c.getName().equals(name)){
                categoriesByName.add(c);
            }
        }
        return categoriesByName;
    }
    
    
}
