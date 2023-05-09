package co.edu.unicauca.openmarket.domain;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Category {
    private Long categoryId;
    private String name;

    public Category(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
