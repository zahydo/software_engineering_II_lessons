/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.openmarket.access;

import java.util.List;
import co.edu.unicauca.openmarket.domain.Category;

/**
 *
 * @author william
 */
public interface ICategoryRepository {
    boolean saveC(Category newCategory);
    
    boolean editC(Long categoryId, Category category);
    
    boolean deleteC(Long id);

    Category findByIdC(Long id);
    
    Category findByNameC (String name);
    
    List<Category> findAllC();
}
