
package com.unicauca.openmarket.service;

import com.unicauca.openmarket.access.dao.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author brayan
 */
@Service
public class CategoryServiceImpl implements ICategoryService{

    
    @Autowired//para que se inyecte el repositorio
    private ICategoryRepository repository;
    /**
     * Servicio para buscar todas las categorias
     * @return listado de categorias
     */
    @Override
     @Transactional(readOnly=true)//para que este sincronizada con la base de datos
    public List<Category> findAll() {
       return (List<Category>)repository.findAll();
    }
    /**
     *  Servicio para buscar categorias por su id
     * @param categoryId de la categoria a buscar
     * @return bjeto tipo categoria
     */
    @Override
    @Transactional
    public Category find(Long categoryId) {
        Category cat=repository.findById(categoryId).orElse(null);
        return cat;
    }
    /**
     * servicio para crear una categoria 
     * @param category de la categoria
     * @return categoria creada
     */
    @Override
    @Transactional
    public Category create(Category category) {
      return repository.save(category);
    }
    
    /**
     * servicio para editar una categoria 
     * @param categoryId el id de la categoria
     * @param category objeto de tipo category para actualizar
     * @return objeto tipo categoria
     */
    @Override
    @Transactional
    public Category update(Long categoryId, Category category) {
       Category cat=this.find(categoryId);
       cat.setName(category.getName());
       return repository.save(cat);
    }
    /**
     * Servicio para elimiunar un categoria por id
     * @param id el id dela categoria a eliminar
     */
    @Override
    @Transactional
    public void delete(Long categoryId) {
       repository.deleteById(categoryId);
    }
    
}
