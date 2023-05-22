
package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.access.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SANTIAGO
 */
@Service //Para que sea un componente de spring

public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    ICategoryRepository repository; 
    
    /**
     * Servicio para encontrar todos los categorias
     * @return Listado en categorias. 
     */
    @Transactional(readOnly =  true)
    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    /**
     * Servicio para encontrar un categoria con su id
     * @param  id identificador del categoria. 
     * @return Objeto de tipo categoria.  
     */
    @Override
    public Category find(long id) {
        Category category = repository.findById(id).orElse(null);
        return category;
    }

    /**
     * Servicio para crear un categoria.
     * @param  category categoria que se va a crear en la bd. 
     * @return Objeto de tipo categoria.  
     */
    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

     /**
     * Servicio para editar un categoria. 
     * @param  id El id del categoria a actualizar. 
     * @param  category categoria que contiene los datos editados en la bd. 
     * @return Objeto de tipo categoria.  
     */
    @Override
    public Category update(long id, Category category) {
        Category cat = this.find(id);
        cat.setName(category.getName());
        return repository.save(cat);
    }

    /**
     * Servicio para eliminar un categoria por id. 
     * @param id el id del categoria a eliminar. 
     */
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
