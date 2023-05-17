package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryArrayService {

    private List<Category> categories;

    public CategoryArrayService(){
        this.categories = new ArrayList<>();
    }

    public List<Category> getCategories(){
        return categories;
    }

    public void setCategory(List<Category> cCategories){
        this.categories = cCategories;
    }

    public Category upsertCategory(Category categoria, boolean createNewOne){
        Category categ = null;
        for(Category c : categories){
            if(
                categoria.getCategoryId() != null && 
                c.getCategoryId().equals(categoria.getCategoryId())
            ){
                c.setCategoryId(categoria.getCategoryId());
                c.setName(categoria.getName());

                categ = c;
                break;
            }
        }

        if(categ == null && createNewOne){
            categ.setCategoryId((long)(categories.size()+1));
            categories.add(0, categoria);
            categ = categoria;
        }
        return categ;
    }

    public boolean deleteCategory(Long id){
        for (Category category : categories) {
            if(category.getCategoryId().equals(id)){
                categories.remove(category);
                return true;
            }
            
        }

        return false;
    }

    public Category findCategorybyId(long id){
        for (Category category : categories) {
            if(category.getCategoryId().equals(id)){
                return category;
            }
            
        }

        return null;
    }

    public List<Category> findCategoryByname(String name){
        List<Category> categorybyname = new ArrayList<>();
        for (Category category : categorybyname) {
            if (category.getName().equals(name)) {
                categorybyname.add(category);
                
            }
            
        }

        return categorybyname;

    }
    
}
