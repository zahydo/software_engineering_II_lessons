package com.unicauca.consumercategory.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.consumercategory.access.repository.ICategoryEventRepository;
import com.unicauca.consumercategory.domain.entity.CategoryEvent;

@Service // Para que sea un componente de Spring
public class CategoryEventServiceImpl implements ICategoryEventService {
    @Autowired // Inyecta una dependencia
    private ICategoryEventRepository repository;

    /**
     * Busca todos los evento de categoryos
     * 
     * @return Lista de evento de categoryos
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoryEvent> findAll() {
        return (List<CategoryEvent>) repository.findAll();
    }

    /**
     * Busca un evento de categoryo por su id
     * 
     * @param id id del evento de categoryo
     * @return evento de categoryo
     */
    @Override
    @Transactional
    public CategoryEvent find(Long id) {
        CategoryEvent category = repository.findById(id).orElse(null);
        return category;
    }

    /**
     * Crea un evento de categoryo
     * 
     * @param category evento de categoryo a crear
     * @return evento de categoryo creado
     */
    @Override
    @Transactional
    public CategoryEvent create(CategoryEvent category) {

        // Save the category
        CategoryEvent savedCategory = repository.save(category);
        // Send the event message
        return savedCategory;

    }

    /**
     * Actualiza un evento de categoryo
     * 
     * @param id       id del evento de categoryo
     * @param category evento de categoryo a actualizar
     * @return evento de categoryo actualizado
     */
    @Override
    @Transactional
    public CategoryEvent update(Long id, CategoryEvent category) {
        CategoryEvent categoryUpdate = this.find(id);
        categoryUpdate.setName(category.getName());
        categoryUpdate.setDescription(category.getDescription());
        // Save the category
        CategoryEvent updateCategory = repository.save(categoryUpdate);
        // Send the event message
        return updateCategory;
    }

    /**
     * Elimina un evento de categoryo
     * 
     * @param id id del evento de categoryo
     */
    @Override
    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }
}
